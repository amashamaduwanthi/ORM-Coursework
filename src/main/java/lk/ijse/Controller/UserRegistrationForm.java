package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.Custom.PersonBO;
import lk.ijse.BoFactory.BOFactory;
import lk.ijse.Entity.Person;

import java.io.IOException;

public class UserRegistrationForm {
    public TextField txtUserName;
    public TextField txtEmail;
    public TextField txtPassword;
    public TextField txtRePassword;
    public Label lblId;
    public AnchorPane UserRegPanel;
    public TextField txtNIC;
    public TextField txtAddress;
    public TextField txtTel;
    PersonBO personBO = (PersonBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.PERSON);

    public void btnRegisterOnAction(ActionEvent actionEvent) {
        String name = txtUserName.getText();
        String nic = txtNIC.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();
        String password = txtPassword.getText();
        String id = lblId.getText();

        Person person = new Person(name, nic, email, address, tel, password,id);
        personBO.savePerson(person);
    }


    public void btnSignInAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/user-Login-Form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) UserRegPanel.getScene().getWindow();
        stage.setScene(scene);
    }
    public void  initialize(){
        generateClientId();
    }
    private void generateClientId() {
        String id =personBO.generateClientId();
        lblId.setText(id);
    }
}
