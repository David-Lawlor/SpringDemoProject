package org.lawlor.spring5webapp.repositories;

import org.lawlor.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
