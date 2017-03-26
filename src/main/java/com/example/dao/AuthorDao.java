package com.example.dao;

import com.example.domain.Author;
import com.example.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by nik on 3/26/17.
 */
@PersistenceContext(unitName = "adminEntityManagerFactory")
public interface AuthorDao extends CrudRepository<Author, Long> {

    List<Author> findByFirstName(String firstName);
}