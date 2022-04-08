package com.the.simone.seor.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.the.simone.seor.entity.Post;
import com.the.simone.seor.entity.Utente;
import com.the.simone.seor.sevice.PostService;
import com.the.simone.seor.sevice.UtenteService;

@SpringBootTest
@AutoConfigureMockMvc
public class TestController {
	
	@InjectMocks
	UtenteService utenteServ;
	@InjectMocks
	PostService postService;
	
	@Mock
	Utente dao;
	@Mock
	Post daoPost;
	
	@Test
	public void inserisci_thenOK() {
		
		
		// case test tutto ok
		
//		dao.setNome("tonio");
//		dao.setCognome("cartonio");
//		dao.setEmail("ngulla@gmail.com");
//		dao.setUsername("fantabosco");
//		
//		String ciao = "ciao";
//		
//		when(utenteServ.inserisciUtente(dao)).thenReturn(ciao);
//		
//		assertEquals("tonio", dao.getNome());
//		assertEquals("ciao", utenteServ.inserisciUtente(dao));
		
		
	}
	
	@Test
	public void inserisciPost_thenOK() {
		
		// prova inserimento post
		daoPost.setOra("adesso");
		daoPost.setDescrizione("descrizione prova");
		daoPost.setTitolo("titolo prova");
		daoPost.setUtente(dao);
		
		//String response = "tutto ok";
		
		when(postService.inserisciPost1(daoPost)).thenReturn(daoPost);
		
		assertEquals("adesso", daoPost.getOra());
		assertEquals(daoPost, postService.inserisciPost1(daoPost));
	}

}
