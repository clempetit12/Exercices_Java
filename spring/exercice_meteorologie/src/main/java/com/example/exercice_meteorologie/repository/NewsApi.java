package com.example.exercice_meteorologie.repository;

import com.example.exercice_meteorologie.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NewsApi extends JpaRepository<News, Long> {
}
