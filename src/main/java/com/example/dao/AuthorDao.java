package com.example.dao;

import com.example.domain.Author;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by nik on 3/26/17.
 */
@PersistenceContext(unitName = "adminEntityManagerFactory")
@Repository
public interface AuthorDao extends CrudRepository<Author, Long> {

    List<Author> findByFirstName(String firstName);
    List<Author> findByFirstNameLike(String firstName);

    List<Author> findByLastName(String lastName);

    List<Author> findByFirstNameOrderByFirstNameAsc(String firstName);

    List<Author> findByFirstNameOrderByFirstNameDesc(String firstName);


    List<Author> findByFirstNameAndLastName(String firstName, String lastName);
    List<Author> findByFirstNameAndLastNameAllIgnoreCase(String firstName, String lastName);

    List<Author> findByFirstNameOrLastName(String firstName, String lastName);
    List<Author> findByFirstNameOrLastNameAllIgnoreCase(String firstName, String lastName);

    List<Author> findTop5ByLastName(String lastName);


   // List<Author> findAuthorDistinctFirstNameOrLastNameAllIgnoreCase(String firstName, String lastName);

    //Long countByLastName(String lastName);

    /*


    List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

  // Enables the distinct flag for the query
  List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
  List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

  // Enabling ignoring case for an individual property
  List<Person> findByLastnameIgnoreCase(String lastname);
  // Enabling ignoring case for all suitable properties
  List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);

  // Enabling static ORDER BY for a query
  List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
  List<Person> findByLastnameOrderByFirstnameDesc(String lastname);


     */


}