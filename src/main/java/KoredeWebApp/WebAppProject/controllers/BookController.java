package KoredeWebApp.WebAppProject.controllers;

import KoredeWebApp.WebAppProject.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") //when we get a request that comes into a book URL, this method is going to get invoked,get a request
    //that comes into the books. It is going to pass in an instance of the spring framework, that spring mvc is attribute to the model
    //called books and model on line 23
    public String getBooks(Model model){
        model.addAttribute("books",bookRepository.findAll()); //add an attribute to the model called books..Underneath
        //there is a lot of books in the repository

        return "book"; //Here we are returning to the MVC
    }
}
