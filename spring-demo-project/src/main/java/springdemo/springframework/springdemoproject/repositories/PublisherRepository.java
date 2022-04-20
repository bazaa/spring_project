package springdemo.springframework.springdemoproject.repositories;

import org.springframework.data.repository.CrudRepository;
import springdemo.springframework.springdemoproject.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
