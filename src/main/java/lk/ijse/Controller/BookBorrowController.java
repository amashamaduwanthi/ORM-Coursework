package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;

public class BookBorrowController {
    public Label lblTitle;
    public Label lblName;
    public Label lblId;
    public Label lblGenre;
    public Label lblAuthor;
    public Label lblStatus;
    public TextField txtUserName;

    public void btnBorrowBookOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/confirmForm.fxml"));
        Parent rootNode = loader.load();

        Scene scene = new Scene(rootNode);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void btnConfirmOnAction(ActionEvent actionEvent) {
        String title = txtUserName.getText();


        try {

            UserDTO userDto = userBo.getUserId(userName);

            if (userDto != null) {
                boolean success = borrowBookBo.placeBorrow(convertToUser(userDto), book);
                if (success) {
                    clearFields();
                    new Alert(Alert.AlertType.CONFIRMATION,"Book borrowed successfull").show();
                } else {
                    clearFields();
                    new Alert(Alert.AlertType.ERROR,"Book borrow Unsuccessfull").show();
                }
            } else {
                clearFields();
                new Alert(Alert.AlertType.ERROR,"Please log into Borrow a Book").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"An Error occurred when borrowing the book").show();
        }
    }

    private void clearFields() {
    }

    public void searchBookDetails(BookDTO bookDto) {
    }
}
