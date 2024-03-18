package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserDashBoardController {
    public AnchorPane userPanel;

    public void btnManageBooksOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/user-book.fxml"));
        userPanel.getChildren().clear();
        userPanel.getChildren().add(anchorPane);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/user-Login-Form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) userPanel.getScene().getWindow();
        stage.setScene(scene);
    }
}
