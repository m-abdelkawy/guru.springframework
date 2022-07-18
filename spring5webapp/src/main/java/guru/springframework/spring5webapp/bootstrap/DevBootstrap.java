package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
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

    private void intiData() {
        // Eric
        Publisher collinsHarper = new Publisher("Collins Harper");
        publisherRepository.save(collinsHarper);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", collinsHarper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        bookRepository.save(ddd);
        authorRepository.save(eric);

        // Rod
        Publisher worx = new Publisher("Worx");
        publisherRepository.save(worx);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        bookRepository.save(noEJB);
        authorRepository.save(rod);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        intiData();
    }
}
