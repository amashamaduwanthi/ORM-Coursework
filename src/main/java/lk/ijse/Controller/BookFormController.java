package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.BoFactory.BOFactory;
import lk.ijse.Entity.Book;

import java.sql.SQLException;

public class BookFormController {
   
    public AnchorPane BookPanel;
    public TextField txtTitle;
    public TextField txtAuthor;
    public TextField txtGenre;
    public TextField txtStatus;
    public TextField TXTID;
    BookBO bookBO = (BookBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.BOOK);

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = TXTID.getText();
        String name = txtTitle.getText();
        String author = txtAuthor.getText();
        String genre = txtGenre.getText();
        String status = txtStatus.getText();
        Book book = new Book(id, name, author, genre, status);
        bookBO.updateBook(book);
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = TXTID.getText();
        bookBO.deleteBook(id);
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String id = TXTID.getText();
        Book book = bookBO.searchBook(id);
        if(book!=null){
            txtTitle.setText(book.getTitle());
            txtAuthor.setText(book.getAuthor());
            txtGenre.setText(book.getGenre());
            txtStatus.setText(book.getStatus());
        }else{
            new Alert(Alert.AlertType.ERROR,"Not found!!!").show();
        }

    }


        public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
            String id = TXTID.getText();
            String title = txtTitle.getText();
            String author = txtAuthor.getText();
            String genre = txtGenre.getText();
            String status = txtStatus.getText();

            Book book = new Book(id, title, author, genre, status);
            bookBO.saveBook(book);
        }

}
