package com.example.springboot.repository;

import com.example.springboot.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByLastName(String lastName);

//	@Query(value)
//	List<Client> findClient();
}
