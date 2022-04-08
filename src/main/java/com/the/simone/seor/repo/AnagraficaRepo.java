package com.the.simone.seor.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.the.simone.seor.entity.Anagrafica;

public interface AnagraficaRepo extends JpaRepository<Anagrafica, String>{

	Anagrafica findByUtenteUsername(String username);
}
