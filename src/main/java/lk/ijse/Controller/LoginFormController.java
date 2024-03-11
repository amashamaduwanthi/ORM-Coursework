package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane loginPanel;
    public TextField txtUser;
    public TextField txtEmail;
    public TextField txtPassword;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Dashboard-Form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) loginPanel.getScene().getWindow();
        stage.setScene(scene);
    }

    public void btnSinInOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Signup-Form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) loginPanel.getScene().getWindow();
        stage.setScene(scene);
    }
}
