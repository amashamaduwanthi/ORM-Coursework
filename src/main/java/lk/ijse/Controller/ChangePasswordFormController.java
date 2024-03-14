package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.BO.Custom.PersonBO;
import lk.ijse.BO.Custom.SettingFormBO;
import lk.ijse.BoFactory.BOFactory;
import lk.ijse.DAO.RegisterDto;
import lk.ijse.Dto.AdminDTO;
import lk.ijse.Dto.RegisterDTO;
import lk.ijse.Dto.UserDTO;
import lk.ijse.Entity.Person;

import java.util.List;

public class ChangePasswordFormController {

    public Label txtName;
    public Label txtEmail;
    public Label txtTel;
    public Label TxtAddress;
    public TextField txtPassword;
    public TextField txtSearchId;
    public Label txtUserId;
    PersonBO personBO = (PersonBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.PERSON);

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String id =txtSearchId.getText();
        String name = txtName.getText();
        String tel = txtTel.getText();
        String email =txtTel.getText();
        String address = TxtAddress.getText();
        String newPw = txtPassword.getText();
        String userId = txtUserId.getText();

        Person person = new Person(id, name, email, address, tel, newPw, userId);
        personBO.changePassword(person);
    }



    public void btnSearchOnAction(ActionEvent actionEvent) {
        String searchId =txtSearchId.getText();
        Person person=personBO.searchPerson(searchId);
        if(person!=null){
            txtUserId.setText(person.getUserID());
            txtName.setText(person.getUserName());
            txtTel.setText(person.getTel());
            txtEmail.setText(person.getEmail());
            TxtAddress.setText(person.getAddress());

        }else{
            new Alert(Alert.AlertType.ERROR,"Not found!!!").show();
        }


    }
    }