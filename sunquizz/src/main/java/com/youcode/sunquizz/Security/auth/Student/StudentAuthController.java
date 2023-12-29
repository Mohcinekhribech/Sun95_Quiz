//package com.youcode.sunquizz.Security.auth.Student;
//
//import com.youcode.sunquizz.Security.User.DTOs.UserRequest;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/auth/student")
//@RequiredArgsConstructor
//public class StudentAuthController {
//
//    private final StudentAuthenticationService service;
//
//    @PostMapping("/register")
//    public ResponseEntity<StudentAuthenticationResponse> register(
//            @RequestBody UserRequest request
//    ) {
//        return ResponseEntity.ok(service.register(request));
//    }
//    @PostMapping("/authenticate")
//    public ResponseEntity<StudentAuthenticationResponse> authenticate(
//            @RequestBody StudentAuthenticationRequest request
//    ) {
//        return ResponseEntity.ok(service.authenticate(request));
//    }
//
//    @PostMapping("/refresh-token")
//    public void refreshToken(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws IOException {
//        service.refreshToken(request, response);
//    }
//
//
//}