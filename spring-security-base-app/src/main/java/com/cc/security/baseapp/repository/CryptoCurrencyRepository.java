package com.cc.security.baseapp.repository;

import com.cc.security.baseapp.entity.CryptoCurrency;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CryptoCurrencyRepository extends MongoRepository<CryptoCurrency, String> {

    CryptoCurrency findBySymbol(String symbol);
}
