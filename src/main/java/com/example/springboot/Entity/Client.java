package com.example.springboot.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

	@Id
	@GeneratedValue
	private Long id;

	@Size(min=2, max=10)
	@NotEmpty
	private String firstName;

	@NotEmpty
	@Size(min=2, max=10)
	private String lastName;


	public Client(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
