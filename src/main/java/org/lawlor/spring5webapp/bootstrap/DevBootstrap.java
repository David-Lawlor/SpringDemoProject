package org.lawlor.spring5webapp.bootstrap;

import org.lawlor.spring5webapp.model.Author;
import org.lawlor.spring5webapp.model.Book;
import org.lawlor.spring5webapp.model.Publisher;
import org.lawlor.spring5webapp.repositories.AuthorRepository;
import org.lawlor.spring5webapp.repositories.BookRepository;
import org.lawlor.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData() {
        Author eric = new Author("Eric", "Evans");
        Publisher dddPublisher = new Publisher("Harper Collins", "123 Fake Street");
        Book ddd = new Book("Domain Driven Design", "1234",  dddPublisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(dddPublisher);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher noEJBPublisher = new Publisher("Worx", "123 Fake Street");
        Book noEJB = new Book("J2EE Development without EJB", "12344", noEJBPublisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(noEJBPublisher);
        bookRepository.save(noEJB);
    }
}