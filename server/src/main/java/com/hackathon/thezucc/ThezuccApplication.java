package com.hackathon.thezucc;

import com.github.javafaker.Faker;
import com.hackathon.thezucc.users.model.User;
import com.hackathon.thezucc.users.repository.UsersRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

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

        Map<Integer, String> neighborhoods = new HashMap<>();

        neighborhoods.put(0, "Riverdale");
        neighborhoods.put(1, "Englewood");
        neighborhoods.put(2, "Washington Park");
        neighborhoods.put(3, "Fuller Park");
        neighborhoods.put(4, "West Englewood");
        neighborhoods.put(5, "Burnside");
        neighborhoods.put(6, "South Deering");
        neighborhoods.put(7, "Pullman");
        neighborhoods.put(8, "South Chicago");
        neighborhoods.put(9, "Grand Crossing");


        for (int i = 0; i < 100; i++) {
            String first = faker.name().fullName();
            String last = faker.name().lastName();

            int blockNumber = i / 10;

            User user = User.builder()
                    .firstName(first)
                    .lastName(last)
                    .qrId(i)
                    .blockNumber(blockNumber)
                    .neighborhood(neighborhoods.get(blockNumber % 10))
                    .build();
            usersRespository.save(user);
        }
    }

}
