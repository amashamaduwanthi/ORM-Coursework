package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.Custom.PersonBO;
import lk.ijse.BoFactory.BOFactory;

import java.io.IOException;

public class UserLoginFormController {
    public AnchorPane loginPanel;
    public TextField txtUser;
    public TextField txtEmail;
    public TextField txtPassword;
    PersonBO personBO = (PersonBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.PERSON);

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        String username = txtUser.getText();
        String password = txtPassword.getText();
        boolean login = personBO.checkPassword(username, password);
        if(username.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Empty").show();
            return;
        }
        if (login) {

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Book-borrow-Form.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) loginPanel.getScene().getWindow();
            stage.setScene(scene);

            new Alert(Alert.AlertType.CONFIRMATION, "Logged in Successfully");
        } else {
            new Alert(Alert.AlertType.ERROR, "oops! credentials are incorrect!").show();
        }
    }

    public void btnSinInOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/UserRegistration.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) loginPanel.getScene().getWindow();
        stage.setScene(scene);

    }
}
