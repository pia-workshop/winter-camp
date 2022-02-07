package com.wintercamp.piademo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wintercamp.piademo.model.User;

public interface UserRepository extends MongoRepository<User, UUID> {

	User findByUsername(String userName);

	List<User> findByName(String name);

}
