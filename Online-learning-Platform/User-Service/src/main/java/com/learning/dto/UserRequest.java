package com.learning.dto;

import com.learning.constants.Role;

import lombok.Data;

@Data
public class UserRequest {
	private String name;
    private String email;
    private String password;
    private Role role;

}
