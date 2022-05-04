package springdemo.springframework.springdemoproject.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springdemo.springframework.springdemoproject.domain.Author;
import springdemo.springframework.springdemoproject.domain.Book;
import springdemo.springframework.springdemoproject.domain.Publisher;
import springdemo.springframework.springdemoproject.repositories.AuthorRepository;
import springdemo.springframework.springdemoproject.repositories.BookRepository;
import springdemo.springframework.springdemoproject.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //create book and author 1
        Author eric = new Author("alex", "baza");
        Book programming = new Book("Level Programming", "12345");

        //add book and author to books and authors
        eric.getBooks().add(programming);
        programming.getAuthors().add(eric);

        //save book and author to database
        authorRepository.save(eric);
        bookRepository.save(programming);

        Author zero = new Author("zero", "baza");
        Book dogs = new Book("eating paper", "49574049");
        zero.getBooks().add(dogs);
        dogs.getAuthors().add(zero);

        authorRepository.save(zero);
        bookRepository.save(dogs);

        //create a new publisher
        Publisher publisher1 = new Publisher("penguin","123 Nowhere Street","Morris", "AK", 30481);
        // save that publisher
        publisherRepository.save(publisher1);

        //add publisher to book and save it
        dogs.setPublisher(publisher1);
        publisher1.getBooks().add(dogs);

        programming.setPublisher(publisher1);
        publisher1.getBooks().add(programming);


        System.out.println("Bootstrap started this");
        System.out.println("Number of books " + bookRepository.count());
        System.out.println("publisher " + publisher1);
        System.out.println("number of publishers " + publisherRepository.count());
        System.out.println("number of books in publisher " + publisher1.getBooks().size());
    }
}
