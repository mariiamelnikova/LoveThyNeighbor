package com.hackathon.thezucc.users.repository;

import com.hackathon.thezucc.users.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UsersRespository extends MongoRepository<User, String> {

    User findByQrId(long id);
    List<User>findAllByBlockNumber(long blockNumber);
}
