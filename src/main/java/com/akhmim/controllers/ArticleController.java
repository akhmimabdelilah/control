package com.akhmim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhmim.entities.Article;
import com.akhmim.services.ArticleService;

@RestController
@RequestMapping("/control/articles")
public class ArticleController {
	@Autowired
	private ArticleService service;

	@GetMapping
	public List<Article> findAllArticles() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Article professeur = service.findById(id);
		if (professeur == null) {
			return new ResponseEntity<Object>("Article avec Id " + id + " nexiste pas", HttpStatus.BAD_REQUEST);

		} else {
			return ResponseEntity.ok(professeur);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletArticle(@PathVariable Long id) {
		Article professeur = service.findById(id);
		if (professeur == null) {
			return new ResponseEntity<Object>("Article avec Id " + id + " nexiste pas", HttpStatus.BAD_REQUEST);
		} else {
			service.delete(professeur);
			return ResponseEntity.ok("professeur avec id " + id + " suprime");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateArticle(@PathVariable Long id, @RequestBody Article newprofesseur) {

		Article oldArticle = service.findById(id);
		if (oldArticle == null) {
			return new ResponseEntity<Object>("professeur avec id" + id + "nexiste pas ", HttpStatus.BAD_REQUEST);

		} else {
			newprofesseur.setId(id);
			return ResponseEntity.ok(service.update(newprofesseur));
		}
	}

	@PostMapping
	public Article creatArticle(@RequestBody Article professeur) {
		professeur.setId(0L);
		return service.create(professeur);
	}

}
