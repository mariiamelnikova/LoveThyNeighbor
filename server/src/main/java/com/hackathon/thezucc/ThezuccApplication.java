package com.hackathon.thezucc;

import com.github.javafaker.Faker;
import com.hackathon.thezucc.users.model.Fundraiser;
import com.hackathon.thezucc.users.model.User;
import com.hackathon.thezucc.users.repository.UsersRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.*;

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

            List<Fundraiser> fundraisers = new ArrayList<>();
            for (int j = 0; j < new Random().nextInt(3); i++) {

                int random = new Random().nextInt(100000);
                fundraisers.add(Fundraiser.builder()
                        .name(faker.animal().name().toUpperCase() + " Fund")
                        .goal(random)
                        .totalSoFar(new Random().nextInt(random))
                        .build());
            }

            User user = User.builder()
                    .firstName(first)
                    .lastName(last)
                    .qrId(i)
                    .blockNumber(blockNumber)
                    .neighborhood(neighborhoods.get(blockNumber % 10))
                    .fundraisers(fundraisers)
                    .build();
            usersRespository.save(user);
        }
    }

}
