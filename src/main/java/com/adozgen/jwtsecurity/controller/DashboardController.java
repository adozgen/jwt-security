package com.adozgen.jwtsecurity.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dashboard")
public class DashboardController {

    @GetMapping("/index")
    public ResponseEntity<String> getDashboard(){
        return ResponseEntity.ok("Welcome to dashboard"); // ResponseEntity.ok(data)
    }
}
