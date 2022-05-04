package com.wcs.dockerspring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wcs.dockerspring.entity.Article;
import com.wcs.dockerspring.repository.ArticleRepository;

@RestController
@CrossOrigin
@RequestMapping("/articles")
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;
	
	@GetMapping
	public List<Article> getAll(){
		return articleRepository.findAll();
	}
	
	@PostMapping
	public Article create(@Valid @RequestBody Article article) {
		return articleRepository.save(article);
	}
	
	@PutMapping("/{id}")
	public Article update(@PathVariable int id, @Valid @RequestBody Article article) {
		Article articleToUpdate = articleRepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		articleToUpdate.setTitle(article.getTitle());
		articleToUpdate.setDescription(article.getDescription());
		return articleRepository.save(articleToUpdate);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		articleRepository.deleteById(id);
	}
}
