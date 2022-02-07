package com.wintercamp.piademo.model;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User {
	@Id
	private UUID id;
	@NotNull(message = "Boş olamaz")
	private String username;
	private String name;
	private String lastname;
	
}
