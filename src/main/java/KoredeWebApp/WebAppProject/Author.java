package KoredeWebApp.WebAppProject;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity //A Jpa that is basically meant fro curating all our classes..More like making it appear for mapping
public class Author {
    @Id //In this case we inform the Java of the Unique Id using the Persistence Api
    @GeneratedValue(strategy = GenerationType.AUTO) //Then we continue to generate it
    private Long Id; //in a case of persistence, we create a unique identifier for the list of our authors
    private String firstname;
    private String secondName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<Book>();

    public Author() {
    }

    public Author(String firstname, String secondName) {
        this.firstname = firstname;
        this.secondName = secondName;
    }

    public Author(String firstname, String secondName, Set<Book> books) {
        this.firstname = firstname;
        this.secondName = secondName;
        this.books = books;
    }

    public Author(Long id) {
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override //There could be two author with same name. What we need to input here is unique business key. To implement it
    //We introduce the hashcode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(Id, author.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override //This is pretty much for the sake of aesthetics
    public String toString() {
        return "Author{" +
                "Id=" + Id +
                ", firstname='" + firstname + '\'' +
                ", secondName='" + secondName + '\'' +
                ", books=" + books +
                '}';
    }
}
