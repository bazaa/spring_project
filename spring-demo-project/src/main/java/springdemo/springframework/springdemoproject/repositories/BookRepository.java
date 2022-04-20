package springdemo.springframework.springdemoproject.repositories;

import org.springframework.data.repository.CrudRepository;
import springdemo.springframework.springdemoproject.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
