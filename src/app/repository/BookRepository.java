package app.repository;

import app.model.Book;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private static final String FILE_PATH = "books.txt";

    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    books.add(new Book(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void save(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

