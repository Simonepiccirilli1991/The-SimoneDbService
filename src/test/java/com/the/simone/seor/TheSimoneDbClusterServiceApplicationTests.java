package com.the.simone.seor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.the.simone.seor.entity.Anagrafica;
import com.the.simone.seor.entity.Post;
import com.the.simone.seor.entity.Sicurezza;
import com.the.simone.seor.entity.Utente;
import com.the.simone.seor.model.error.AnagraficaExc;
import com.the.simone.seor.model.error.PostExc;
import com.the.simone.seor.model.error.UtenteExc;
import com.the.simone.seor.repo.AnagraficaRepo;
import com.the.simone.seor.repo.PostURepo;
import com.the.simone.seor.repo.UtentiPRepo;
import com.the.simone.seor.sevice.AnagraficaService;
import com.the.simone.seor.sevice.PostService;
import com.the.simone.seor.sevice.SicurezzaService;
import com.the.simone.seor.sevice.UtenteService;

@SpringBootTest
@AutoConfigureMockMvc
class TheSimoneDbClusterServiceApplicationTests {

	
	
	@InjectMocks
	UtenteService utenteServ;
	@InjectMocks
	PostService postService;
	@InjectMocks
	AnagraficaService anagServ;
	@InjectMocks
	SicurezzaService sicuServ;
	
	@Mock
	Utente dao;
	@Mock
	UtentiPRepo utentiPRepo;
	@Mock
	Post daoPost;
	@Mock
	PostURepo postRepo;
	@Mock
	Anagrafica anaDAO;
	@Mock
	Sicurezza sicurezza;
	@Mock 
	AnagraficaRepo anagRepo;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	// test inserisci Utente
	@Test
	public void inserisci_thenOK() throws Exception {
		
		
		// case test tutto ok
		
		dao.setEmail("ngulla@gmail.com");
		dao.setUsername("fantabosco");
		
		Utente ciao = new Utente();
		
		when(utentiPRepo.save(ArgumentMatchers.any(Utente.class))).thenReturn(ciao);
		
		String response = utenteServ.inserisciUtente(dao);
	
		assertThat(response).isSameAs("Utente inserito correttamente");
		
	}
	// test di errore inserisci Utente
	@Test
	public void inserisciUtente_thenKO() {
		when(utentiPRepo.save(ArgumentMatchers.any(Utente.class))).thenReturn(dao).thenThrow(UtenteExc.class);
		
		utenteServ.inserisciUtente(dao);
		 
		Assertions.assertThrows(UtenteExc.class, () -> utenteServ.inserisciUtente(dao));
		
	}
	
	//Test inserisci post
	@Test
	public void inserisciPost_thenOK() {
		
		// prova inserimento post
		daoPost.setOra("adesso");
		daoPost.setDescrizione("descrizione prova");
		daoPost.setTitolo("titolo prova");
		daoPost.setUtente(dao);

		
		when(postRepo.save(ArgumentMatchers.any(Post.class))).thenReturn(daoPost);
		
		postService.inserisciPost1(daoPost);
		
		assertEquals(daoPost, postService.inserisciPost1(daoPost));
	}
	//Test errore inserisci Post
	@Test 
	public void inserisciPost_thenKO() {
		
		when(postRepo.save(ArgumentMatchers.any(Post.class))).thenReturn(daoPost).thenThrow(PostExc.class);
		postService.inserisciPost1(daoPost);
		 Assertions.assertThrows(PostExc.class, () -> postService.inserisciPost1(daoPost));
		
	}
	// CANCELLA TUTTI UTENTI
	@Test
	public void cancellaTuttiUtenti_thenOK()  {
		
		String response = utenteServ.brasaTutti();
		
		assertEquals("hai brasati tutto , vai cavallo", response);
		
	}
	// cancella tutti Utenti errore
	@Test
	public void cancellaTuttiUtenti_thenKO() {
		
		when(utenteServ.brasaTutti()).thenThrow(UtenteExc.class);
		Assertions.assertThrows(UtenteExc.class, () -> utenteServ.brasaTutti());	
	}
	
	@Test
	public void inserisciAnagrafica_thenOk() {
		
		anaDAO.setCognome("frolla");
		anaDAO.setNome("frolla");
		anaDAO.setComune("milazzo");
		anaDAO.setDataNascita("56");
		anaDAO.setUtente(dao);
		
		Anagrafica response2 = new Anagrafica();
		response2.setNome("minchia");
		when(anagRepo.save(ArgumentMatchers.any(Anagrafica.class))).thenReturn(response2);
		
		Anagrafica response = anagServ.inserisciAnagrafica(anaDAO);
		
		assertEquals(anaDAO, anagServ.inserisciAnagrafica(anaDAO));
		assertEquals("minchia", response2.getNome());
		
		
	}
	
	@Test
	public void inserisciAnagrafica_thenKO() {
		
		when(anagRepo.save(ArgumentMatchers.any(Anagrafica.class))).thenReturn(anaDAO).thenThrow(AnagraficaExc.class);
		anagServ.inserisciAnagrafica(anaDAO);
		 Assertions.assertThrows(AnagraficaExc.class, () -> anagServ.inserisciAnagrafica(anaDAO));
		
	}


}
