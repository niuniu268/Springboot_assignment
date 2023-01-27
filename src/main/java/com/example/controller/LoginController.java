package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public void checkInfo(@PathParam( "username" ) String username, @PathParam("password") String password){

    }
}
