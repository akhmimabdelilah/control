package com.akhmim.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;

	@JsonIgnore
	@OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
	private List<Article> articles;

	@JsonIgnore
	@ManyToOne
	private Categorie categorieparent;

	public Categorie() {
		super();
	}

	public Categorie(long id) {
		super();
		this.id = id;
	}

	public Categorie(String nom) {
		super();
		this.nom = nom;
	}

	public Categorie(long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Categorie(long id, String nom, Categorie categorieparent) {
		super();
		this.id = id;
		this.nom = nom;
		this.categorieparent = categorieparent;
	}

	public Categorie(long id, String nom, List<Article> articles, Categorie categorieparent) {
		super();
		this.id = id;
		this.nom = nom;
		this.articles = articles;
		this.categorieparent = categorieparent;
	}

	public Categorie(long id, String nom, List<Article> articles) {
		super();
		this.id = id;
		this.nom = nom;
		this.articles = articles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Categorie getCategorieparent() {
		return categorieparent;
	}

	public void setCategorieparent(Categorie categorieparent) {
		this.categorieparent = categorieparent;
	}

}
