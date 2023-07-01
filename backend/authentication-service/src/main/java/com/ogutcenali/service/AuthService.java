package com.ogutcenali.service;

import com.ogutcenali.config.security.JwtService;
import com.ogutcenali.dto.request.AuthenticationRequest;
import com.ogutcenali.dto.request.RegisterRequest;
import com.ogutcenali.dto.request.UpdateAuthRequest;
import com.ogutcenali.exception.AuthException;
import com.ogutcenali.exception.EErrorType;
import com.ogutcenali.model.Auth;
import com.ogutcenali.model.enums.ERole;
import com.ogutcenali.rabbitmq.model.CreateCustomer;
import com.ogutcenali.rabbitmq.producer.AuthProducer;
import com.ogutcenali.repository.IAuthRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    private final IAuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    private final AuthProducer authProducer;

    public AuthService(IAuthRepository authRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService, AuthProducer authProducer) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.authProducer = authProducer;
    }
    @Transactional
    public void register(RegisterRequest registerRequest) {
        checkUserExists(registerRequest.getEmail());
        createAuth(registerRequest);

    }
    private void createAuth(RegisterRequest registerRequest) {
        Auth auth = Auth.builder()
                .email(registerRequest.getEmail())
                .role(ERole.USER)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();
        authRepository.save(auth);
        producerCustomerCreate(auth);
    }
    private void producerCustomerCreate(Auth auth) {
        authProducer.createCustomer(CreateCustomer.builder()
                .authId(auth.getId())
                .email(auth.getEmail())
                .build());
    }
    private void checkUserExists(String email) {
        Optional<Auth> auth = authRepository.findByEmail(email);
        auth.ifPresent(user -> {
            throw new AuthException(EErrorType.AUTH_EMAIL_ERROR);
        });
    }
    @Transactional
    public String authenticate(AuthenticationRequest authenticationRequest) {
        Auth auth = findAuthByEmail(authenticationRequest.getEmail());
        matchesPassword(auth, authenticationRequest.getPassword());
        return jwtService.generateToken(auth);
    }
    private void matchesPassword(Auth auth, String password) {
        if (!passwordEncoder.matches(password, auth.getPassword()))
            throw new AuthException(EErrorType.AUTH_PASSWORD_ERROR);
    }
    private Auth findAuthByEmail(String email) {
        Optional<Auth> auth = authRepository.findByEmail(email);
        if (auth.isEmpty()) throw new AuthException(EErrorType.KULLANICI_BULUNAMADI);
        return auth.get();
    }
    @Transactional
    public void updateAuth(UpdateAuthRequest updateAuthRequest) {
        Optional<Auth> auth = authRepository.findById(updateAuthRequest.getId());
        if (updateAuthRequest.getEmail() != null) auth.get().setEmail(updateAuthRequest.getEmail());
        if (updateAuthRequest.getPassword() != null)
            auth.get().setPassword(passwordEncoder.encode(updateAuthRequest.getPassword()));
        authRepository.save(auth.get());
    }
}
