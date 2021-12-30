package com.news.publisher.repo;

import com.news.publisher.model.Doc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocRepo extends JpaRepository<Doc, Integer> {

}
