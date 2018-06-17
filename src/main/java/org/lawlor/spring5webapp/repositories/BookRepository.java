package org.lawlor.spring5webapp.repositories;

import org.lawlor.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
