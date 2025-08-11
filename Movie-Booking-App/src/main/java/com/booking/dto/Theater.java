package com.booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Theater {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;
	
	private String name;
    private String location;
}
