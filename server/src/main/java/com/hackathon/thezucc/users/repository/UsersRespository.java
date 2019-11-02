package com.hackathon.thezucc.users.repository;

import com.hackathon.thezucc.users.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRespository extends MongoRepository<User, String> {

    User findByQrId(long id);
}
