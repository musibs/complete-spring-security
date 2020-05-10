package com.cc.security.baseapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;

@Getter
@ToString
@EqualsAndHashCode
public class Transaction {

    @Id
    private String id;
    private final Type type;
    @DBRef
    private final CryptoCurrency cryptoCurrency;
    private final BigDecimal quantity;
    private final BigDecimal price;
    private final long timestamp;

    public Transaction(Type type, CryptoCurrency cryptoCurrency, BigDecimal quantity, BigDecimal price, long timestamp) {
        this.id = new ObjectId().toHexString();
        this.type = type;
        this.cryptoCurrency = cryptoCurrency;
        this.quantity = quantity;
        this.price = price;
        this.timestamp = timestamp;
    }
}
