package com.projectmania.journalApp.repository;

import com.projectmania.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String userName); // ✅ Corrected method name

    void deleteByUserName(String userName);
}
