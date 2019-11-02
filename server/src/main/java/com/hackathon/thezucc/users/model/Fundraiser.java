package com.hackathon.thezucc.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fundraiser {
    private String name;
    private int goal;
    private int totalSoFar;
}
