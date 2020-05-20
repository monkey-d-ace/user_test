package com.berry.service;

import com.berry.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends MongoRepository<User, String> {
}
