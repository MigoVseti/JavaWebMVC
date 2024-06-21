package ru.ithub.js6c.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.js6c.models.Article;

public interface ArticleRepository  extends JpaRepository<Article, Integer> {
}
