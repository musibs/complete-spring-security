package io.codefountain.spring.security.basics.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationExample {

	private static AuthenticationManager am = new SampleAuthenticationManager();
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Enter username: ");
			String name = reader.readLine();
			
			System.out.println("Enter password: ");
			String password = reader.readLine();
			
			
			try {
				
				Authentication request = new UsernamePasswordAuthenticationToken(name, password);
				Authentication result = am.authenticate(request);
				SecurityContextHolder.getContext().setAuthentication(result);
				break;
			}
			catch(AuthenticationException ae) {
				System.out.println("Authentication failed: "+ae.getMessage());
			}
		}
		System.out.println("Successfully authenticated. Security context contains: "+SecurityContextHolder.getContext().getAuthentication());
	}
}


class SampleAuthenticationManager implements AuthenticationManager{
	
	private static List<GrantedAuthority> AUTHORITIES = new ArrayList<>();
	
	static {
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if(authentication.getName().equals(authentication.getCredentials())) {
			return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), AUTHORITIES);
		}
		throw new BadCredentialsException("Bad Credentails");
	}
	
}