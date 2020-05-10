package com.cc.security.baseapp.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;

@Getter
@ToString
@Document
@RequiredArgsConstructor
public class User {

    @Id
    private String id;

    @NonNull
    private final String username;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @Email
    @NonNull
    private String email;
    @NonNull
    private String password;
}
