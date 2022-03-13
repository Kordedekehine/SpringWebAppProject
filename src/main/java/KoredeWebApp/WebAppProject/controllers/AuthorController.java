package KoredeWebApp.WebAppProject.controllers;


import KoredeWebApp.WebAppProject.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthor(Model model){
      model.addAttribute("authors",authorRepository.findAll());

      return "author";
    }
}
