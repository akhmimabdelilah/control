package com.akhmim.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhmim.dao.IDao;
import com.akhmim.entities.Article;
import com.akhmim.repositories.ArticleRepository;

@Service
public class ArticleService implements IDao<Article> {

	@Autowired
	private ArticleRepository repository;

	@Override
	public Article create(Article o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Article o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Article update(Article o) {
		return repository.save(o);
	}

	@Override
	public Article findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Article> findAll() {
		return repository.findAll();
	}

	public List<Article> findByCategorieBetweenDate(long id, Date dateDebut, Date dateFin) {
		return repository.findByCategorieBetweenDate(id, dateDebut, dateFin);
	}

}
