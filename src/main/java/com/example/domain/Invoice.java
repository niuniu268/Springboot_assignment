package com.example.domain;

import lombok.Data;

@Data
public class Invoice {

    private Integer id;

    private String username;
    private String password;

    private String title;

    private String date;

    private String beskrivning;

    private String category;

    private Integer pris;

}
