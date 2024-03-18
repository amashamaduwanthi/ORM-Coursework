package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.ijse.BO.Custom.UserBO;
import lk.ijse.BOFactory.BOFactory;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane loginPanel;
    public TextField txtuserName;
    public TextField txtPassword;

    UserBO userBO = (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.USER);
    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {

        String username = txtuserName.getText();
        String password = txtPassword.getText();
        boolean login = userBO.checkPassword(username, password);
        if(username.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Empty").show();
            return;
        }
        if (login) {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Dashboard-Form.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) loginPanel.getScene().getWindow();
            stage.setScene(scene);
//            Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/navigation_form.fxml"));
//            Scene scene =new Scene(rootNode);
//            Stage primaryStage = (Stage) this.rootNode.getScene().getWindow();
//            primaryStage.setScene(scene);
//            primaryStage.setTitle("BookWorm");
            new Alert(Alert.AlertType.CONFIRMATION, "Logged in Successfully");
        } else {
            new Alert(Alert.AlertType.ERROR, "oops! credentials are incorrect!").show();
        }

    }

    public void btnSignInOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Signup-Form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) loginPanel.getScene().getWindow();
        stage.setScene(scene);
    }



    public void btnExitOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/First-Form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) loginPanel.getScene().getWindow();
        stage.setScene(scene);
    }
}
