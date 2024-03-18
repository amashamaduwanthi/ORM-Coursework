package lk.ijse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity(name = "borrowBooks")
public class BorrowBooks {
    @Id
//    @GeneratedValue(generator = "Borrowed-Id-Generator")
//    @GenericGenerator(name = "Borrowed-Id-Generator", strategy = "lk.ijse.util.BorrowedIdGenerator")
    private String gId;
    @ManyToOne
    @JoinColumn(name = "person",referencedColumnName = "uId")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "book",referencedColumnName = "bId")
    private Book book;
    private LocalDateTime borrowedDate;
    private LocalDateTime returnDate;

    public BorrowBooks() {
    }

    public BorrowBooks(String gId, Person user, Book book, LocalDateTime borrowedDate, LocalDateTime returnDate) {
        this.gId = gId;
        this.person = user;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public Person getUser() {
        return person;
    }

    public void setUser(Person user) {
        this.person = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDateTime borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BorrowedBooks{" +
                "gId='" + gId + '\'' +
                ", user=" + person+
                ", book=" + book +
                ", borrowedDate=" + borrowedDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
