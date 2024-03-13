package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserLoginFormController {
    public AnchorPane loginPanel;

    public void btnLoginOnAction(ActionEvent actionEvent) {
    }

    public void btnSinInOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/UserRegistration.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) loginPanel.getScene().getWindow();
        stage.setScene(scene);

    }
}
