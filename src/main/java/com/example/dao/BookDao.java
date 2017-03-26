package com.example.dao;

import com.example.domain.Book;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by nik on 3/26/17.
 */

@PersistenceContext(unitName = "adminEntityManagerFactory")
public interface BookDao extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}