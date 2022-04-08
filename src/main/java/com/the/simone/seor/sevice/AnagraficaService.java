package com.the.simone.seor.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the.simone.seor.entity.Anagrafica;
import com.the.simone.seor.model.error.AnagraficaExc;
import com.the.simone.seor.repo.AnagraficaRepo;

@Service
public class AnagraficaService {
	
	@Autowired
	private AnagraficaRepo anagraficaRepo;
	
	public Anagrafica inserisciAnagrafica(Anagrafica request) throws AnagraficaExc {
		
		try {
			anagraficaRepo.save(request);
		}catch(Exception e) {
			throw new AnagraficaExc();
		}
		return request;
	}
	
	// inserisce e ritorna stringa per test
	public String inserisciAnagraficaS(Anagrafica request) throws AnagraficaExc {
		String response = "";
		try {
			anagraficaRepo.save(request);
			response = "Utente inserito con successo";
		}catch(Exception e) {
			throw new AnagraficaExc();
		}
		return response;
	}
	
	public Anagrafica cercaAnagraficaByUsername(String username) throws AnagraficaExc {
		
		Anagrafica response = new Anagrafica();
		try {
			response = anagraficaRepo.findByUtenteUsername(username);
			
		}catch(Exception e) {
			throw new AnagraficaExc();
		}
		return response;
	}

}
