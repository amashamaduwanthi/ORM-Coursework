package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {
    public AnchorPane singInPanel;

    public void btnSignInAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/login-Form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) singInPanel.getScene().getWindow();
        stage.setScene(scene);
    }
}
