package com.example.dao;

import com.example.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by nik on 3/26/17.
 */

@PersistenceContext(unitName = "adminEntityManagerFactory")
@Repository
public interface BookDao extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
    Book findById(long id);
}