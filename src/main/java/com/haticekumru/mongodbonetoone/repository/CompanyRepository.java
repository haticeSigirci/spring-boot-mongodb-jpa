package com.haticekumru.mongodbonetoone.repository;

import com.haticekumru.mongodbonetoone.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface CompanyRepository extends MongoRepository<Company, String> {

    List<Company> findByName(String name);

    @Query("{'contact.address': ?0}")
    List<Company> findByAddress(String address);

}
