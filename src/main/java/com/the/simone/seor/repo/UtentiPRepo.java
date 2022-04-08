package com.the.simone.seor.repo;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.the.simone.seor.entity.Utente;

public interface UtentiPRepo extends  JpaRepository<Utente, Long>{


	Utente findByUsername(String username);
	
	boolean existsByUsername(String username);

	
	
}
