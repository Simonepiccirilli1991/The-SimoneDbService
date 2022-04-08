package com.the.simone.seor.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.the.simone.seor.entity.Post;

public interface PostURepo extends JpaRepository<Post, Long>{
	
	List<Post> findByUtenteId(Long utenteId);
	
	
	@Transactional
	void deleteByUtenteId(Long utenteId);
	;

}
