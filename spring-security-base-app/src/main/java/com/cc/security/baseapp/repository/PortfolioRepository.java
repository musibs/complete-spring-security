package com.cc.security.baseapp.repository;

import com.cc.security.baseapp.entity.Portfolio;
import com.cc.security.baseapp.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PortfolioRepository extends MongoRepository<Portfolio, String > {
    Portfolio findByUsername(String username);
}
