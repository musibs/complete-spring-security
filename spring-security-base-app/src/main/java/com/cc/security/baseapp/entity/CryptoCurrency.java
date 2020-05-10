package com.cc.security.baseapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@ToString
@Document
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"id", "symbol"})
public class CryptoCurrency {

    @Id
    private String id;

    @Indexed(unique = true)
    private final String symbol;
    private final String name;
}
