package com.srs.controller;

import java.util.Map;

import javax.management.InstanceAlreadyExistsException;
import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srs.entity.Admin;
import com.srs.entity.Customer;
import com.srs.repos.AdminRepository;
import com.srs.services.CustomerService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
    private CustomerService customerService;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private com.srs.security.jwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Customer registration
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerCustomer(@RequestBody Customer customer) {
        try {
            Customer saved = customerService.register(customer);

            Map<String, Object> success = Map.of(
                "status", 200,
                "message", "Registered successfully",
                "customerId", saved.getCustomerId()
            );
            return ResponseEntity.status(201).body(success);

        } catch (IllegalArgumentException ex) {
            Map<String, Object> error = Map.of(
                "status", 400,
                "message", ex.getMessage() != null ? ex.getMessage() : "Invalid request data"
            );
            return ResponseEntity.badRequest().body(error);

        } catch (Exception ex) {
            Map<String, Object> error = Map.of(
                "status", 409,
                "message", "User already exists with this email"
            );
            return ResponseEntity.status(500).body(error);
        }
    }




    // Admin registration
    @PostMapping("/register-admin")
    public ResponseEntity<Map<String, Object>> registerAdmin(@RequestBody Admin admin) {
        try {
            // encode password
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));

            // save to DB
            Admin saved = adminRepository.save(admin);

            // success response
            Map<String, Object> success = Map.of(
                "status", 200,
                "message", "Admin registered successfully",
                "adminId", saved.getAdminId()
            );
            return ResponseEntity.status(201).body(success);

        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            // duplicate username/email (constraint violation)
            Map<String, Object> error = Map.of(
                "status", 409,
                "message", "Admin already exists with given credentials"
            );
            return ResponseEntity.status(409).body(error);

        } catch (IllegalArgumentException ex) {
            // bad request data
            Map<String, Object> error = Map.of(
                "status", 400,
                "message", ex.getMessage() != null ? ex.getMessage() : "Invalid request data"
            );
            return ResponseEntity.badRequest().body(error);

        } catch (Exception ex) {
            // unexpected server error
            Map<String, Object> error = Map.of(
                "status", 500,
                "message", "An unexpected error occurred"
            );
            return ResponseEntity.status(500).body(error);
        }
    }

    

    // Login (common for both)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) throws AuthenticationException {
        String username = body.get("username");
		String password = body.get("password");
		authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		String token = jwtUtil.generateToken(username);
		return ResponseEntity.ok(Map.of("token", token));
    }
}
