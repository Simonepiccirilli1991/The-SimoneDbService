package com.the.simone.seor.sevice;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the.simone.seor.entity.Utente;
import com.the.simone.seor.model.error.UtenteExc;

@Service
public class CheckPswService {
	
	@Autowired
	private UtenteService utServ;
	
	public boolean checkPsw(String username, String psw) throws UtenteExc{
		
		boolean response = false;
		Utente utenteDAO = utServ.cercaUtente(username);
		
		
		if(utenteDAO != null) {
			if(utenteDAO.getPsw().equals(psw)) {
				response = true;
			}
		}else {
			throw new UtenteExc();
		}
		return response;
	}

}
