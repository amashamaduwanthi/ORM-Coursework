package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.BOFactory.BOFactory;
import lk.ijse.DTO.BookDTO;

import java.io.IOException;

public class UserBookController {
    public Label lblBookId;
    public Label lblBookName;
    public Label lblAuthor;
    public Label lblGenera;
    public Label lblStatus;
    public TextField txtSearchBook;
    BookBO bookBo = (BookBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.BOOK);

    public void btnBoorowOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/View/confirmForm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    public void btnSearchOnAction(ActionEvent actionEvent) {
        String title = txtSearchBook.getText();

        BookDTO bookDto = bookBo.searchBook(title);

        if(bookDto != null){
            lblBookId.setText(bookDto.getbId());
            lblBookName.setText(bookDto.getTitle());
            lblAuthor.setText(bookDto.getAuthor());
            lblGenera.setText(bookDto.getGenre());
            lblStatus.setText(bookDto.getStatus());
//                clearFields();
        }else {
            new Alert(Alert.AlertType.ERROR,"Book Not Found").show();
        }
    }
}
