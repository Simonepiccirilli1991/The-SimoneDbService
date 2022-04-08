package com.the.simone.seor.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the.simone.seor.entity.Sicurezza;
import com.the.simone.seor.model.error.SicurezzaExc;
import com.the.simone.seor.repo.SicurezzaRepo;

@Service
public class SicurezzaService {
	
	@Autowired
	private SicurezzaRepo sicurezzaRepo;
	
	public Sicurezza inserisciDatiSicurezza(Sicurezza request) throws SicurezzaExc{
		
		
			Sicurezza response = sicurezzaRepo.save(request);

		return response;
	}
	
	public void cancellaDatiSicurezzaUtente(String username) throws SicurezzaExc {
		try {
			sicurezzaRepo.deleteByUtenteUsername(username);
		}catch(Exception e) {
			throw new SicurezzaExc();
		}
	}
	
	public void aggiornaDatiUtente(String username, Sicurezza request) throws SicurezzaExc {
		try {
			sicurezzaRepo.findByUtenteUsername(username);
			sicurezzaRepo.save(request);
		}catch(Exception e) {
			throw new SicurezzaExc();
		}
	}
	
	public void certificaMailUtente(String username, boolean mailCertificata) throws SicurezzaExc {
		
		
		try {
			Sicurezza response = sicurezzaRepo.findByUtenteUsername(username);
			response.setEmailConfermata(mailCertificata);
			sicurezzaRepo.save(response);
			
		}catch(Exception e) {
			throw new SicurezzaExc();
		}
	}

}
