package com.example;

import java.util.List;

import javax.sql.DataSource;

import com.example.dao.AuthorDao;
import com.example.dao.BookDao;
import com.example.domain.Author;
import com.example.domain.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.dao.CustomerDao;
import com.example.domain.Customer;

@Configuration
@EnableJpaRepositories
public class Application {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/school");
		datasource.setUsername("root");
		datasource.setPassword("nik2098");
		return datasource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource);
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		lef.setPackagesToScan("com.example.domain");
		return lef;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				Application.class);

		CustomerDao repositoryCustomer = context.getBean(CustomerDao.class);
		AuthorDao repositoryAuthor = context.getBean(AuthorDao.class);
		BookDao repositoryBook = context.getBean(BookDao.class);
		/*
		// save a couple of customers
		repositoryCustomer.save(new Customer("Jack", "Bauer"));
		repositoryCustomer.save(new Customer("Chloe", "O'Brian"));
		repositoryCustomer.save(new Customer("Kim", "Bauer"));
		repositoryCustomer.save(new Customer("David", "Palmer"));
		repositoryCustomer.save(new Customer("Michelle", "Dessler"));

		// fetch all customers
		Iterable<Customer> customers = repositoryCustomer.findAll();
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Customer customer = repositoryCustomer.findOne(1L);
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		// fetch customers by last name
		List<Customer> bauers = repositoryCustomer.findByLastName("Bauer");
		System.out.println("Customer found with findByLastName('Bauer'):");
		System.out.println("--------------------------------------------");
		for (Customer bauer : bauers) {
			System.out.println(bauer);
		}

		*/

		Author author = new Author();
		author.setFirstName("Ivan");
		author.setLastName("Vazov");

		Book book = new Book();
		book.setAuthor(author);
		book.setTitle("Pod igoto");

		author.addBook(book);

		repositoryAuthor.save(author);

		context.close();
	}

}
