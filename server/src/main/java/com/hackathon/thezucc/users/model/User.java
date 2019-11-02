package com.hackathon.thezucc.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Users")
public class User {

    @Id
    private ObjectId _id;

    private long qrId;
    private long blockNumber;
    private String neighborhood;
    private String firstName;
    private String lastName;
    private List<Fundraiser> fundraisers;
}
