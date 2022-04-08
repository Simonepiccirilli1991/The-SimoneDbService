package com.the.simone.seor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.the.simone.seor.entity.Anagrafica;
import com.the.simone.seor.entity.Sicurezza;
import com.the.simone.seor.entity.Utente;
import com.the.simone.seor.fragment.request.InserisciSicRequest;
import com.the.simone.seor.sevice.SicurezzaService;
import com.the.simone.seor.sevice.UtenteService;




@RestController
@RequestMapping("sicurezza")
public class SicurezzzaController {
	
	@Autowired
	private UtenteService utenteServ;
	@Autowired
	private SicurezzaService sicService;
	
	
	@PostMapping("v1/sic/inserisci")
	public ResponseEntity<Sicurezza> inserisciSicurezza(@RequestBody InserisciSicRequest request){
		
		Utente response = utenteServ.trovaConUsername(request.getUsername());
		  request.getSicurezza().setUtente(response);
		  
		  return new ResponseEntity<Sicurezza>(sicService.inserisciDatiSicurezza(request.getSicurezza()), HttpStatus.CREATED);
	}
	
	
	

}
