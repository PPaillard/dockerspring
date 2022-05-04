package com.wcs.dockerspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.dockerspring.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
