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

import com.the.simone.seor.entity.Post;
import com.the.simone.seor.model.error.PostExc;
import com.the.simone.seor.sevice.PostService;
import com.the.simone.seor.sevice.UtenteService;

@RestController
@RequestMapping("post")
public class PostController {
	
	@Autowired
	private PostService postService;
	@Autowired 
	private UtenteService utenteService;
	
	
//	@PostMapping("/inserisci/{username}/posts")
//	  public ResponseEntity<Post> createPost(@PathVariable(value = "username") String username,
//	      @RequestBody Post postR) throws PostExc{
//	    Post response = utenteService.trovaConUsername(username).map(utente->{
//	    	postR.setUtente(utente);
//	      return postService.inserisciPost1(postR);
//	      }).orElseThrow();
//	    return new ResponseEntity<>(response, HttpStatus.CREATED);
//	  }
	
	 @GetMapping("/trovatutti/{utenteId}/posts")
	  public ResponseEntity<List<Post>> getAllCommentsByTutorialId(@PathVariable(value = "utenteId") Long utenteId) throws PostExc{
	  utenteService.existsById(utenteId);
	    List<Post> response = postService.trovaByUtenteId(utenteId);
	    return new ResponseEntity<>(response, HttpStatus.OK);
	  }
	  
	  
	  @PutMapping("/modifica/{id}")
	  public ResponseEntity<Post> modificaCommento(@PathVariable("id") long id, @RequestBody Post request) throws PostExc {
	    Post response = postService.trovaByPostId(id)
	    		 .orElseThrow();
	    response.setDescrizione(request.getDescrizione());
	    response.setTitolo(request.getTitolo());
	    response.setOra(request.getOra());
	    return new ResponseEntity<>(postService.inserisciPost1(response), HttpStatus.OK);
	  }
	  @PostMapping("/cancella/{id}")
	  public ResponseEntity<String> cancellaPost(@PathVariable("id") long id) {
		  String response = postService.cancellaById(id);
	    return new ResponseEntity<String>(response, HttpStatus.OK);
	  }
	  
	  @PostMapping("/cancellatutto/{tutorialId}/post")
	  public ResponseEntity<String> cancellaTuttiCommentiUtente(@PathVariable(value = "utenteId") Long utenteId) throws PostExc{
		  utenteService.existsById(utenteId);
		 String response =  postService.cancellaByUtenteId(utenteId);
	    return new ResponseEntity<String>(response ,HttpStatus.OK);
	  }

}
