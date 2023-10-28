package com.graphql.learn.controllers;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Controller
public class GraphQLController {
    @Autowired
    private BookService bookService;

    @MutationMapping("create")
    public Book create(@Argument BookInput book){
        Book b= new Book();
        b.setPages(book.getPages());
        b.setTitle(book.getTitle());
        b.setPrice(book.getPrice());
        b.setAuthor(book.getAuthor());
        b.setDesc(book.getDesc());
        return this.bookService.create(b);
    }

    @QueryMapping("allBooks")
    public List<Book> getAll(){
        return this.bookService.getAll();
    }
    @QueryMapping("getBook")
    public Book get(@Argument int bookId){
        return this.bookService.get(bookId);
    }

    //POST TO localhost:8010/graphql
//    mutation {
//        create(book:{
//            title: "This is sample book",
//                    desc:"test",
//                    pages:200,
//                    price: 500,
//                    author: "Sanjeev"
//        }) {
//            author
//        }
//    }
//    query {
//        getBook(bookId: 1) {
//            author
//        }
//    }

//    query {
//        allBooks {
//            author
//        }
//    }

}

@Getter
@Setter
class BookInput {
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;
}
