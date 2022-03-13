package KoredeWebApp.WebAppProject.repositories;

import KoredeWebApp.WebAppProject.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

}
