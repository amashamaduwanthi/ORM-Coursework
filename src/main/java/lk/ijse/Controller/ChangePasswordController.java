package lk.ijse.Controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import lk.ijse.BO.Custom.PersonBO;
import lk.ijse.BOFactory.BOFactory;

public class ChangePasswordController {
    public AnchorPane settingPanel;
    public TextField txtSearchID;
    public TextField txtNewPassword;

    public Label lblUserId;
    public Label txtname;
    public Label txttel;
    public Label txtemail;
    public Label txtaddress;
    PersonBO personBO = (PersonBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.PERSON);
//    public void btnSearchPersonOnAction(ActionEvent actionEvent) {
//        String searchId = txtSearchID.getText();
//        Person person=personBO.searchPerson(searchId);
//        if(person!=null){
//
//            txtname.setText(person.getUserName());
//            txtemail.setText(person.getEmail());
//            txtaddress.setText(person.getAddress());
//
//        }else{
//            new Alert(Alert.AlertType.ERROR,"Not found!!!").show();
//        }
//    }

//    public void btnChangePasswordOnAction(ActionEvent actionEvent) {
//
//        String id = txtSearchID.getText();
//        String name = txtname.getText();
//        String tel = txttel.getText();
//        String email = txtemail.getText();
//        String address = txtaddress.getText();
//        String newPw = txtNewPassword.getText();
//        String userId = lblUserId.getText();
//
//        Person person = new Person(id,name,email,address,tel,newPw,userId);
//        personBO.changePassword(person);
//    }
}
