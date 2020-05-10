package com.cc.security.baseapp.repository;

import com.cc.security.baseapp.entity.SupportQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SupportQueryRepository extends MongoRepository<SupportQuery, String> {

    List<SupportQuery> findByUsername(String username);
}
