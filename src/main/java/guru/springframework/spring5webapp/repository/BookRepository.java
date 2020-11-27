package guru.springframework.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.domain.Books;

public interface BookRepository extends CrudRepository<Books, Long> {

}
