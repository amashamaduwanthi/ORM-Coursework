package lk.ijse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lk.ijse.DAO.DAOFactory.CrudDAO;

@Entity
public class Book {
    @Id
    private String ISBN;

    private String title;

    private String author;

    private String genre;
    private String status;

    public Book(){

    }
    public Book(String ISBN,String title,String author,String genre,String  status){
        this.ISBN=ISBN;
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.status=status;
    }

    public Book(String ISBN) {
        this.ISBN=ISBN;
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ISBN+title+author+genre+status;
    }

    public static interface PersonDAO extends CrudDAO<Person> {

        boolean checkPassword(String username, String password);
        String generateUserID();

    }
}
