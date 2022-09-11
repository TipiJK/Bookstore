package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookRunner(BookRepository repository) {
		return (args) -> {
			log.info("saves example books");
			repository.save(new Book("Title","Author Name","ISBN", 99.99, 1999));
			repository.save(new Book("Title2","Another Author","ISBN2", 88.89, 2009));
			
			log.info("fetch all titles");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
