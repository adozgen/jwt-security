package com.adozgen.jwtsecurity.controller;


import com.adozgen.jwtsecurity.request.RegisterRequest;
import com.adozgen.jwtsecurity.request.UserRequest;
import com.adozgen.jwtsecurity.response.UserResponse;
import com.adozgen.jwtsecurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> save(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authenticationService.save(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(authenticationService.login(userRequest));
    }
}
