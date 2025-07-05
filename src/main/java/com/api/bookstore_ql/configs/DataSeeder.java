package com.api.bookstore_ql.configs;

import com.api.bookstore_ql.models.AuthorModel;
import com.api.bookstore_ql.models.BookModel;
import com.api.bookstore_ql.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private AuthorModel createAuthorWithBook(String authorName, String bookTitle, String publisher) {
        var author = new AuthorModel();
        author.setName(authorName);

        var book = new BookModel();
        book.setTitle(bookTitle);
        book.setPublisher(publisher);
        book.setAuthor(author);

        author.getBooks().add(book);
        return author;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if(authorRepository.count() == 0) {
            var author = createAuthorWithBook("Mark Heckler", "Spring Boot: Up and Running", "O'Reilly Media");
            var anotherAuthor = createAuthorWithBook("William Smith", "Mastering GraphQL: From Basics to Expert Proficiency",
                    "HiTeX Press");
            authorRepository.saveAll(List.of(author, anotherAuthor));
        }
    }
}
