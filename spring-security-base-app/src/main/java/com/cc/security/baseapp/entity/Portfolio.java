package com.cc.security.baseapp.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.List;

@Document
@Getter
@RequiredArgsConstructor
public class Portfolio {

    @Id
    private String id;
    @NonNull
    private final String username;
    private final List<Transaction> transactions;

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

    public List<Transaction> getTransactions(){
        return Collections.unmodifiableList(transactions);
    }
}
