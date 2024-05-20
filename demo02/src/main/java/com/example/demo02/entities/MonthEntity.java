package com.example.demo02.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthEntity {

    private Integer monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;
}