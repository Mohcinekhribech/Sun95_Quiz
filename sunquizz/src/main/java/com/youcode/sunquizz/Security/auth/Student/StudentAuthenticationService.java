//package com.youcode.sunquizz.Security.auth.Student;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.youcode.sunquizz.Security.User.DTOs.UserRequest;
//import com.youcode.sunquizz.Security.User.Role;
//import com.youcode.sunquizz.Security.User.User;
//import com.youcode.sunquizz.Security.jwt.JwtService;
//import com.youcode.sunquizz.Security.token.Token;
//import com.youcode.sunquizz.Security.token.TokenRepository;
//import com.youcode.sunquizz.Security.token.TokenType;
//import com.youcode.sunquizz.domains.User.Student.Student;
//import com.youcode.sunquizz.domains.User.Student.StudentRepository;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.time.LocalDate;
//
//@Service
//@RequiredArgsConstructor
//public class StudentAuthenticationService {
//    private final StudentRepository repository;
//    private final TokenRepository tokenRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtService jwtService;
//    private final AuthenticationManager authenticationManager;
//    private final ModelMapper modelMapper;
//
//    public StudentAuthenticationResponse register(UserRequest request) {
//        var student = Student.builder()
//                .firstName(request.getFirstName())
//                .lastName(request.getLastName())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .role(Role.Student)
//                .build();
//        Student student1 = modelMapper.map(student,Student.class);
//        student1.setRegistrationDate(LocalDate.now());
//        student1.setDateOfBirth(request.getDateOfBirth());
//        student1 = repository.save( modelMapper.map(student1,Student.class));
//        var jwtToken = jwtService.generateToken(student);
//        var refreshToken = jwtService.generateRefreshToken(student);
//        saveUserToken(student1, jwtToken);
//        return StudentAuthenticationResponse.builder()
//                .accessToken(jwtToken)
//                .refreshToken(refreshToken)
//                .build();
//    }
//
//    public StudentAuthenticationResponse authenticate(StudentAuthenticationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getEmail(),
//                        request.getPassword()
//                )
//        );
//        var user = repository.findByEmail(request.getEmail())
//                .orElseThrow();
//        var jwtToken = jwtService.generateToken(user);
//        var refreshToken = jwtService.generateRefreshToken(user);
//        revokeAllUserTokens(user);
//        saveUserToken(user, jwtToken);
//        return StudentAuthenticationResponse.builder()
//                .accessToken(jwtToken)
//                .refreshToken(refreshToken)
//                .build();
//    }
//
//    private void saveUserToken(Student user, String jwtToken) {
//        var token = Token.builder()
//                .user(user)
//                .token(jwtToken)
//                .tokenType(TokenType.BEARER)
//                .expired(false)
//                .revoked(false)
//                .build();
//        tokenRepository.save(token);
//    }
//
//    private void revokeAllUserTokens(User user) {
//        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
//        if (validUserTokens.isEmpty())
//            return;
//        validUserTokens.forEach(token -> {
//            token.setExpired(true);
//            token.setRevoked(true);
//        });
//        tokenRepository.saveAll(validUserTokens);
//    }
//
//    public void refreshToken(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws IOException {
//        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//        final String refreshToken;
//        final String userEmail;
//        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
//            return;
//        }
//        refreshToken = authHeader.substring(7);
//        userEmail = jwtService.extractUsername(refreshToken);
//        if (userEmail != null) {
//            var user = this.repository.findByEmail(userEmail)
//                    .orElseThrow();
//            if (jwtService.isTokenValid(refreshToken, user)) {
//                var accessToken = jwtService.generateToken(user);
//                revokeAllUserTokens(user);
//                saveUserToken(user, accessToken);
//                var authResponse = StudentAuthenticationResponse.builder()
//                        .accessToken(accessToken)
//                        .refreshToken(refreshToken)
//                        .build();
//                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
//            }
//        }
//    }
//}