package com.example.domain;

import lombok.Data;

@Data
public class Kvitton {

    private String userName;
    private String password;

    private String title;

    private String data;

    private String beskrivning;

    private String category;

    private Integer pris;

}
