package app.controller;

import app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BookController {
    private final BookService bookService;

    @Value("${app.welcome.message:Добро пожаловать в библиотеку!}")
    private String welcomeMessage;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void start() {
        System.out.println(welcomeMessage);
        bookService.addBook("1984", "George Orwell");
        bookService.addBook("To Kill a Mockingbird", "Harper Lee");

        System.out.println("Список книг:");
        bookService.getAllBooks().forEach(System.out::println);
    }
}

