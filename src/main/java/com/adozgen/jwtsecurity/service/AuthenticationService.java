package com.adozgen.jwtsecurity.service;

import com.adozgen.jwtsecurity.entity.User;
import com.adozgen.jwtsecurity.enums.Role;
import com.adozgen.jwtsecurity.repository.UserRepository;
import com.adozgen.jwtsecurity.request.RegisterRequest;
import com.adozgen.jwtsecurity.request.UserRequest;
import com.adozgen.jwtsecurity.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public UserResponse save(RegisterRequest registerRequest) {
        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return UserResponse.builder()
                .token(jwtToken)
                .build();
    }

    public UserResponse login(UserRequest userRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getEmail(), userRequest.getPassword()));
        User user = userRepository.findByEmail(userRequest.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return UserResponse.builder()
                .token(jwtToken)
                .build();
    }

}
