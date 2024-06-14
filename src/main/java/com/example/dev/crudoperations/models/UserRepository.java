package com.example.dev.crudoperations.models;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * This UseRepository extends to MongoDBRepository which helps in using in built mongoDB
 * functionality on collections
 * Params: User --> Collections POJO Class and String --> Primary key Type
 */
public interface UserRepository extends MongoRepository<User, String>{

}
