package springdemo.springframework.springdemoproject.repositories;

import org.springframework.data.repository.CrudRepository;
import springdemo.springframework.springdemoproject.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
