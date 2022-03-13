package KoredeWebApp.WebAppProject.bootstrap;

import KoredeWebApp.WebAppProject.Author;
import KoredeWebApp.WebAppProject.Book;
import KoredeWebApp.WebAppProject.Publisher;
import KoredeWebApp.WebAppProject.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import KoredeWebApp.WebAppProject.repositories.AuthorRepository;
import KoredeWebApp.WebAppProject.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> { //the applistener is like an event and the one
    // we want now is context
private AuthorRepository authorRepository;
private BookRepository bookRepository;
private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("Joja Printing press");

        publisherRepository.save(publisher);
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Korede
        Author korede = new Author("Salami", "Korede");
        Book noEjb = new Book("J2EE Development without EJB", "23444", publisher);
        korede.getBooks().add(noEjb);

        authorRepository.save(korede);
        bookRepository.save(noEjb);
    }


}
