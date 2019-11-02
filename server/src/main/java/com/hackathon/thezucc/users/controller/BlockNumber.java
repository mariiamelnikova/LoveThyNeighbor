package com.hackathon.thezucc.users.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.thezucc.users.model.User;
import com.hackathon.thezucc.users.repository.UsersRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class BlockNumber {

    private final UsersRespository usersRespository;

    @GetMapping("/users/block/{blockNumber}")
    public ResponseEntity<String> findByBlockNumber(@PathVariable int blockNumber) {

        try {
            List<User> users = usersRespository.findAllByBlockNumber(blockNumber);

            if (users == null) {
                throw new Exception("No users with that block id: " + blockNumber);
            }

            String s = new ObjectMapper().writeValueAsString(users);
            return new ResponseEntity<>(s, HttpStatus.OK);
        } catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
