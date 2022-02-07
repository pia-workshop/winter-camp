package com.wintercamp.piademo.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
	@NotNull(message = "Username is mandatory")
	private String username;
	@NotNull(message = "name is mandatory")
	private String name;
	@NotNull(message = "lastName is mandatory")
	private String lastName;
}
