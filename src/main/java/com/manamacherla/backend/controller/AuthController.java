package com.manamacherla.backend.controller;


import com.manamacherla.backend.dto.LoginRequest;
import com.manamacherla.backend.entity.Admin;
import com.manamacherla.backend.repository.AdminRepository;
import com.manamacherla.backend.service.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AuthController {

    private final AdminRepository repo;
    private final JwtService jwtService;

    public AuthController(AdminRepository repo, JwtService jwtService) {
        this.repo = repo;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        Admin admin = repo.findByUsername(request.getUsername());

        if (admin != null && admin.getPassword().equals(request.getPassword())) {
            return "{\"token\":\"" + jwtService.generateToken(admin.getUsername()) + "\"}";
        }

        throw new RuntimeException("Invalid login");
    }
}
