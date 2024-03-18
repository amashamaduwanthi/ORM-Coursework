package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainUserController {
    public AnchorPane root;


    public void btnSearchBookOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user-book.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }

    public void btnBorrowBookOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Book-borrow-Form.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }
}
