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

import static java.util.Arrays.asList;

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
        Map<Integer, List<Double>> coords = new HashMap<>();

        neighborhoods.put(0, "Riverdale");
        coords.put(0, asList(41.6654294, -87.6168563));

        neighborhoods.put(1, "Englewood");
        coords.put(1, asList(41.7753688, -87.6590701));

        neighborhoods.put(2, "Washington Park");
        coords.put(2, asList(41.7911619, -87.6349523));

        neighborhoods.put(3, "Fuller Park");
        coords.put(3, asList(41.809107, -87.6499771));

        neighborhoods.put(4, "West Englewood");
        coords.put(4, asList(41.7781042, -87.6754725));

        neighborhoods.put(5, "Burnside");
        coords.put(5, asList(41.7294347, -87.6043656));

        neighborhoods.put(6, "South Deering");
        coords.put(6, asList(41.6915902, -87.6070799));

        neighborhoods.put(7, "Pullman");
        coords.put(7, asList(41.7039213, -87.6155862));

        neighborhoods.put(8, "South Chicago");
        coords.put(8, asList(41.7390541, -87.5725683));

        neighborhoods.put(9, "Grand Crossing");
        coords.put(9, asList(41.7550143, -87.6131881));


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

            int index = blockNumber % 10;

            User user = User.builder()
                    .firstName(first)
                    .lastName(last)
                    .qrId(i)
                    .blockNumber(blockNumber)
                    .neighborhood(neighborhoods.get(index))
                    .fundraisers(fundraisers)
                    .nLat(coords.get(index).get(0))
                    .nLon(coords.get(index).get(1))
                    .lat(coords.get(index).get(0) - (new Random().nextDouble() * 0 + (0.0009 - 0)))
                    .lon(coords.get(index).get(1) - (new Random().nextDouble() * 0 + (0.0009 - 0)))
                    .build();
            usersRespository.save(user);
        }
    }

}
