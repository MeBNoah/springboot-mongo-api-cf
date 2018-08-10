package com.anynines.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.anynines.app.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
