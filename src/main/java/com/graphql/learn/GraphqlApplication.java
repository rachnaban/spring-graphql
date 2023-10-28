package com.graphql.learn;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlApplication implements CommandLineRunner {
@Autowired
	BookService bookService;
	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book b1 = new Book();
		b1.setAuthor("Rachna");
		b1.setDesc("This is my first book");
		b1.setTitle("Java for Newbies");
		b1.setPrice(200);
		b1.setPages(100);
		Book b2 = new Book();
		b2.setAuthor("Saksham");
		b2.setDesc("This is my second book");
		b2.setTitle("Java for Programmers");
		b2.setPrice(200);
		b2.setPages(100);
		this.bookService.create(b1);
		this.bookService.create(b2);
	}
}
