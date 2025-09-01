package com.srs.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.srs.entity.Admin;
import com.srs.entity.Customer;
import com.srs.repos.AdminRepository;
import com.srs.repos.CustomerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // First, try to find customer
        Customer customer = customerRepository.findByEmail(username).orElse(null);
        if (customer != null) {
            return new User(
                    customer.getEmail(),
                    customer.getPassword(),
                    List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER"))
            );
        }

        // Then, try to find admin
        Admin admin = adminRepository.findByEmail(username).orElse(null);
        if (admin != null) {
            return new User(
                    admin.getEmail(),
                    admin.getPassword(),
                    List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
            );
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }

}
