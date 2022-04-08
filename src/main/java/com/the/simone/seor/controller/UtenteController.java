package com.the.simone.seor.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.the.simone.seor.entity.Utente;
import com.the.simone.seor.fragment.request.LoginRequest;
import com.the.simone.seor.model.error.UtenteExc;
import com.the.simone.seor.sevice.CheckPswService;
import com.the.simone.seor.sevice.UtenteService;

@RestController
@RequestMapping("utente")
public class UtenteController {

	@Autowired
	private UtenteService utenteserv;
	@Autowired
	private CheckPswService checkService;


	// inserisci utente
	@PostMapping("/inserisci")
	public String inserisciUtente(@RequestBody Utente request) {

		String response = utenteserv.inserisciUtente(request);

		return response;
	}
	// trova per id // prova non in uso
	@GetMapping("/trovax/{id}")
	public ResponseEntity<Utente> getTUtentiById(@PathVariable("id") long id) {
		Utente utente = utenteserv.cercaUtenteById(id)
				.orElseThrow();
		return new ResponseEntity<>(utente, HttpStatus.OK);
	}

	// trova per username
	@GetMapping("/trovax/{username}")
	public ResponseEntity<Utente> getUtentiByUsername(@PathVariable("username") String username) {
		Utente utente = utenteserv.cercaUtente(username);
		return new ResponseEntity<>(utente, HttpStatus.OK);
	}
	//Modifica per id
	@PostMapping("/modifica/{id}")
	public ResponseEntity<Utente> updateUtente(@PathVariable("id") long id, @RequestBody Utente utente) {
		Utente Utente2 = utenteserv.cercaUtenteById(id)
				.orElseThrow();
		Utente2.setEmail(utente.getEmail());
		Utente2.setUsername(utente.getUsername());
		Utente2.setPsw(utente.getPsw());

		return new ResponseEntity<>(utenteserv.salvaUtente(Utente2), HttpStatus.OK);
	}
	// non in funzione , solo test
	@DeleteMapping("/cancella/{id}")
	public ResponseEntity<HttpStatus> deleteUtente(@PathVariable("id") long id) {
		utenteserv.cancellaById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	//funziona anche con la post
	@PostMapping("/cacellatutti/brasaaa")
	public ResponseEntity<String> deleteAllUtenti() {
		String response = utenteserv.brasaTutti();

		return new ResponseEntity<>(response,HttpStatus.OK);// se httpstatus settato a no comment nonnritorna response valorizata
	}
	// trova utente e torna info - non in uso , solo di prova
	@PostMapping("/trova/{username}")
	public ResponseEntity<Utente> getTUtentiByUsername2(@PathVariable("username") String username) throws UtenteExc{
		Utente utente = utenteserv.trovaConUsername(username);

		return new ResponseEntity<>(utente, HttpStatus.OK);
	}
	// trova utente e torna info
	@GetMapping("/trova/{username}")
	public ResponseEntity<Utente> getTUtentiByUsername(@PathVariable("username") String username) throws UtenteExc{
		Utente utente = utenteserv.trovaConUsername(username);

		return new ResponseEntity<>(utente, HttpStatus.OK);
	}
	// check psw
	@PostMapping("v1/post/login")
	public boolean effettuaLogin(@RequestBody LoginRequest request) {

		return checkService.checkPsw(request.getUsername(), request.getPsw());

	}
	// controlla se username gia in uso
	@PostMapping("/controlla/username")
	public String controllUser(@RequestBody String username) {
		String response ="";
		boolean var1 =  utenteserv.usernameGiaInUse(username);
		if(var1) {
			response = "KO username gia in uso";
		}else {
			response ="OK username libero";
		}
		return response;
	}

}
