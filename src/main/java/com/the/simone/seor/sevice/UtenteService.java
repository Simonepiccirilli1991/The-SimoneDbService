package com.the.simone.seor.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the.simone.seor.entity.Utente;
import com.the.simone.seor.model.error.UtenteExc;
import com.the.simone.seor.repo.UtentiPRepo;

@Service
public class UtenteService {
	
	@Autowired
	private UtentiPRepo utentePRepo;
	
	public String inserisciUtente(Utente request) throws UtenteExc {
		
		String response ="";
		try {
			utentePRepo.save(request);
			response = "Utente inserito correttamente";
		}catch(Exception e) {
			throw new UtenteExc();
		}
		return response;
	}
	
	public String cancellaUtente(Utente request) throws UtenteExc{
		String response = "";
		
		try {
			utentePRepo.delete(request);
			response = " utente cancellato con successo";
		}catch(Exception e) {
			throw new UtenteExc();
		}
		return response;
	}
	
	public Optional<Utente> cercaUtenteById(Long utenteId) throws UtenteExc{
		Optional<Utente> response = utentePRepo.findById(utenteId);
		return response;
	}
	
	public Utente trovaConUsername(String userName)throws UtenteExc{
		Utente response = utentePRepo.findByUsername(userName);
		if(response == null )
			throw new UtenteExc();
		
		return response;
	}
	public void cancellaById(Long utenteId) throws UtenteExc {
		utentePRepo.deleteById(utenteId);
	}
	public Utente salvaUtente(Utente request) throws UtenteExc{
		Utente response = utentePRepo.save(request);
		return response;
	}
	public String brasaTutti() throws UtenteExc {
		utentePRepo.deleteAll();
		return "hai brasati tutto , vai cavallo";
	}

	public boolean existsById(Long utenteId) {
		utentePRepo.existsById(utenteId);
		return true;
	}
	public Utente cercaUtente(String username) throws UtenteExc{
		
		Utente response = utentePRepo.findByUsername(username);
		return response;
	}
	public boolean usernameGiaInUse(String username) {
		boolean response = utentePRepo.existsByUsername(username);
		if(! response)
		  return false;
		
		return true;
	}
	

}
