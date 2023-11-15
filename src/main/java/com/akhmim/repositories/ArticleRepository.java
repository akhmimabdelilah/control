package com.akhmim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akhmim.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

	@Query("SELECT l.produit FROM LigneCommandeProduit l WHERE l.commande.id=:commandeId")
	List<Article> getArticleByCategory(@Param("commandeId") int commandeId);
}
