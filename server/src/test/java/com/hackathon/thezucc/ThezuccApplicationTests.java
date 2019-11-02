package com.hackathon.thezucc;

import com.github.javafaker.Faker;
import com.hackathon.thezucc.users.model.User;
import com.hackathon.thezucc.users.repository.UsersRespository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ThezuccApplicationTests {

    @Autowired
    private UsersRespository usersRespository;


    @Test
    void name() {
        Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            String first = faker.name().fullName();
            String last = faker.name().lastName();

            User user = User.builder()
                    .firstName(first)
                    .lastName(last)
                    .qrId(i)
                    .district(i)
                    .build();
            usersRespository.save(user);
        }
    }
}
