package com.the.simone.seor.repo;


import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.the.simone.seor.entity.Sicurezza;

public interface SicurezzaRepo extends CrudRepository<Sicurezza, Long>{

	
	Sicurezza findByUtenteUsername(String username);
	
	
	@Transactional
	void deleteByUtenteUsername(String username);
	
}
