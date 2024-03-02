package com.opticamejia.app.services;

import com.opticamejia.app.Auth.AuthResponse;
import com.opticamejia.app.Auth.LoginRequest;
import com.opticamejia.app.Auth.RegisterRequest;
import com.opticamejia.app.User.Role;
import com.opticamejia.app.models.UserModel;
import com.opticamejia.app.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())); // autenticar usuario

        // Crear token
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow(); // encontrar usuario
        String token = jwtService.getToken(user); // generarlo
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        UserModel user = UserModel.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .role(Role.USUARIO)
                .build();

        userRepository.save(user); // guardar usuario o registrar

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
