package com.akhmim.entities;

import java.util.List;

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

	@OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
	private List<Article> articles;

	@ManyToOne
	private Categorie categorieParent;
	@OneToMany(mappedBy = "categorieParent", fetch = FetchType.EAGER)
	private List<Categorie> categoriesParent;

	public Categorie() {
		super();
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

}
