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

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UsersController {

    private final UsersRespository usersRespository;

    @GetMapping("/users/{id}")
    public ResponseEntity<String> getUsers(@PathVariable Long id) {

        try {
            User byQrId = usersRespository.findByQrId(id);

            if (byQrId == null) {
                throw new Exception("User not found: " + id);
            }

            ObjectMapper objectMapper = new ObjectMapper();

            String s = objectMapper.writeValueAsString(byQrId);
            return new ResponseEntity<>(s, HttpStatus.OK);
        } catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
