package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.ijse.BO.Custom.UserBO;
import lk.ijse.BOFactory.BOFactory;
import lk.ijse.Entity.User;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpController {
    public AnchorPane SignInPanel;
    public TextField txtUserName;
    public TextField txtEmail;
    public TextField txtPassword;
    public TextField txtConfirmPassword;

    UserBO userBO = (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.USER);
    public void btnRegisterOnAction(ActionEvent actionEvent) throws SQLException {
        String username = txtUserName.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();
        User user = new User(username,email,password,confirmPassword);

        userBO.RegisterUser(user);

    }

    public void btnSignInOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/login-Form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) SignInPanel.getScene().getWindow();
        stage.setScene(scene);
    }
}
