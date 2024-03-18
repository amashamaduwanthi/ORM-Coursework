package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.ijse.BO.Custom.BookBO;
import lk.ijse.BOFactory.BOFactory;
import lk.ijse.DTO.BookDTO;

import java.io.IOException;

public class userBookController {
    public TextField txtSearchBook;
    public AnchorPane root;
    public Label lblBookId;
    public Label lblBookName;
    public Label lblAuthor;
    public Label lblGenre;
    public Label lblStatus;

    BookBO bookBo = (BookBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.BOOK);
    public void btnSearchOnAction(ActionEvent actionEvent) {
        String title = txtSearchBook.getText();

        BookDTO bookDto = bookBo.searchBook(title);

        if(bookDto != null){
            lblBookId.setText(bookDto.getbId());
            lblBookName.setText(bookDto.getTitle());
            lblAuthor.setText(bookDto.getAuthor());
            lblGenre.setText(bookDto.getGenre());
            lblStatus.setText(bookDto.getStatus());
//                clearFields();
        }else {
            new Alert(Alert.AlertType.ERROR,"Book Not Found").show();
        }


    }

    public void btnBorrowOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/confirm-Borrow.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        }
    }

