package com.the.simone.seor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.the.simone.seor.entity.Anagrafica;
import com.the.simone.seor.entity.Utente;
import com.the.simone.seor.fragment.request.AnagraficaRequest;
import com.the.simone.seor.fragment.request.ModificaAnagraficaRequest;
import com.the.simone.seor.model.error.AnagraficaExc;
import com.the.simone.seor.sevice.AnagraficaService;
import com.the.simone.seor.sevice.UtenteService;

@RestController
@RequestMapping("anagrafica")
public class AnagraficaController {
	
	@Autowired
	private AnagraficaService anagServ;
	@Autowired 
	private UtenteService utenteService;
	
	// rimosso , opzione map non disponibile se non si passa parametro Option a oggetto in repository
	
//	@PostMapping("/inserisci/{username}/anagrafica")
//	  public ResponseEntity<Anagrafica> createPost(@PathVariable(value = "username") String username,
//	      @RequestBody Anagrafica anagraficaR) throws AnagraficaExc {
//	    Anagrafica response = utenteService.trovaConUsername(username).map(utente->{
//	    	anagraficaR.setUtente(utente);
//	      return anagServ.inserisciAnagrafica(anagraficaR);
//	      }).orElseThrow();
//	    return new ResponseEntity<>(response, HttpStatus.CREATED);
//	  }
	
	// trova anagrarica di utente
	 @GetMapping("/trova/{username}/anagrafica")
	  public ResponseEntity<Anagrafica> getAnagraficaByUsername(@PathVariable(value = "username") String username) throws AnagraficaExc {
	  utenteService.trovaConUsername(username);
	    Anagrafica response = anagServ.cercaAnagraficaByUsername(username);
	    return new ResponseEntity<>(response, HttpStatus.OK);
	  }
	  
	  // modifica anagrafica di utente
	  @PutMapping("/modifica/{username}")
	  public ResponseEntity<Anagrafica> modificaAnagrafica(@PathVariable("username") String username, @RequestBody Anagrafica request) throws AnagraficaExc {
	    Anagrafica response = anagServ.cercaAnagraficaByUsername(username);
	    		 
	    response.setCognome(request.getCognome());
	    response.setComune(request.getComune());
	    response.setDataNascita(request.getDataNascita());
	    response.setNome(request.getNome());
	    return new ResponseEntity<>(anagServ.inserisciAnagrafica(response), HttpStatus.OK);
	  }
	  // modifica ma in post
	  @PostMapping("/modifica/secret")
	  public ResponseEntity<Anagrafica> modificaAnagraficaPost(@RequestBody AnagraficaRequest request)throws AnagraficaExc {
		  
		  Anagrafica response	=  anagServ.cercaAnagraficaByUsername(request.getUsername());
		  
		  	response.setCognome(request.getAnagrafica().getCognome());
		    response.setComune(request.getAnagrafica().getComune());
		    response.setDataNascita(request.getAnagrafica().getDataNascita());
		    response.setNome(request.getAnagrafica().getNome());
		  return new ResponseEntity<>(anagServ.inserisciAnagrafica(response), HttpStatus.OK);
		  
	  }
	  // dati visibili 
	  @PostMapping("/inserisci/{username}/anagrafica")
	  public ResponseEntity<Anagrafica> inserisciAnagraficaUtente(@PathVariable(value = "username") String username,
	      @RequestBody Anagrafica anagraficaR) throws AnagraficaExc {
	    Utente response = utenteService.trovaConUsername(username);
	    	anagraficaR.setUtente(response);
	       anagServ.inserisciAnagrafica(anagraficaR);
	    return new ResponseEntity<>(anagraficaR, HttpStatus.CREATED);
	  }
	  
	  // dati non visibili
	  @PostMapping("v1/post/inserisci/anagrafica")
	  public ResponseEntity<Anagrafica> creaAnagrafica(@RequestBody AnagraficaRequest request) throws AnagraficaExc{
		  Utente response = utenteService.trovaConUsername(request.getUsername());
		  request.getAnagrafica().setUtente(response);
		  //anagServ.inserisciAnagrafica(request.getAnagrafica());
		  
		  return new ResponseEntity<Anagrafica>(anagServ.inserisciAnagrafica(request.getAnagrafica()), HttpStatus.CREATED);
	  }
	  // ritorna stringa per test
	  @PostMapping("v1/post/inserisci/anagraficaS")
	  public String creaAnagraficaS(@RequestBody AnagraficaRequest request) throws AnagraficaExc{
		  Utente response = utenteService.trovaConUsername(request.getUsername());
		  request.getAnagrafica().setUtente(response);
		  //anagServ.inserisciAnagrafica(request.getAnagrafica());
		  
		 return anagServ.inserisciAnagraficaS(request.getAnagrafica());
	  }
}
