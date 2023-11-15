package com.akhmim.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;

//	@Temporal(TemporalType.DATE)
	private Date dateProduction;

//	@JsonIgnore
	@ManyToOne
	private Categorie categorie;

	public Article() {
		super();
	}

	public Article(long id) {
		super();
		this.id = id;
	}

	public Article(String nom, Date dateProduction) {
		super();
		this.nom = nom;
		this.dateProduction = dateProduction;
	}

	public Article(long id, String nom, Date dateProduction) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateProduction = dateProduction;
	}

	public Article(long id, String nom, Date dateProduction, Categorie categorie) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateProduction = dateProduction;
		this.categorie = categorie;
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

	public Date getDateProduction() {
		return dateProduction;
	}

	public void setDateProduction(Date dateProduction) {
		this.dateProduction = dateProduction;
	}

}
