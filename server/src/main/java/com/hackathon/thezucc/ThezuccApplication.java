package com.hackathon.thezucc;

import com.github.javafaker.Faker;
import com.hackathon.thezucc.users.model.User;
import com.hackathon.thezucc.users.repository.UsersRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class ThezuccApplication {

    private final UsersRespository usersRespository;

    public static void main(String[] args) {
        SpringApplication.run(ThezuccApplication.class, args);
    }

    @PostConstruct
    public void loadDb() {
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
