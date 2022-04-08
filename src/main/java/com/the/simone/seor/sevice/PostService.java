package com.the.simone.seor.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.the.simone.seor.entity.Post;
import com.the.simone.seor.model.error.PostExc;
import com.the.simone.seor.repo.PostURepo;

@Service
public class PostService {

	@Autowired
	private PostURepo postURepo;
	

	
	
	// inizio evolutiva -1
	public Post inserisciPost1(@NonNull Post request) throws PostExc{
		 return postURepo.save(request);
		
	}
	// fine evolutiva -1
	
	public List<Post> trovaByUtenteId(Long utenteId) {
	List<Post> response	=  postURepo.findByUtenteId(utenteId);
	return response;
	}
	
	public Optional<Post> trovaByPostId(Long id){
	Optional<Post> response =	postURepo.findById(id);
	return response;
		
	}
	public String cancellaById(Long id){
		postURepo.deleteById(id);
		return "utente cancellato con successo";
	}
	public String cancellaByUtenteId(Long utenteId){
		postURepo.deleteByUtenteId(utenteId);
		return "tutti i commenti cancellati con successo";
	}
}
