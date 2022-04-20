package springdemo.springframework.springdemoproject.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springdemo.springframework.springdemoproject.domain.Author;
import springdemo.springframework.springdemoproject.domain.Book;
import springdemo.springframework.springdemoproject.repositories.AuthorRepository;
import springdemo.springframework.springdemoproject.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("alex", "baza");
        Book programming = new Book("Level Programming", "12345");
        eric.getBooks().add(programming);
        programming.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(programming);

        Author zero = new Author("zero", "baza");
        Book dogs = new Book("eating paper", "49574049");
        zero.getBooks().add(dogs);
        dogs.getAuthors().add(zero);

        authorRepository.save(zero);
        bookRepository.save(dogs);

        System.out.println("Bootstrap started this");
        System.out.println("Number of books " + bookRepository.count());


    }
}
