package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.BO.Custom.SettingFormBO;
import lk.ijse.BoFactory.BOFactory;
import lk.ijse.DAO.RegisterDto;

import java.util.List;

public class ChangePasswordFormController {
    public TextField txtNewUserName;
    public TextField currentUserName;
    public TextField txtConfirmUserName;
    public TextField txtCurrentPassword;
    public TextField txtNewPassword;
    public TextField txtConfirmPassword;
    SettingFormBO settingFormBO = (SettingFormBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.SETTING);
    public void btnSaveOnAction(ActionEvent actionEvent) {
        String currentUsername = currentUserName.getText();
        String newUsername = txtNewUserName.getText();
        String confirmUsername = txtConfirmUserName.getText();

        String currentPassword = txtCurrentPassword.getText();
        String newPassword = txtNewPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        if (!currentUsername.isEmpty() && !newUsername.isEmpty() && !confirmUsername.isEmpty()){

            boolean isChecked = checkingUsername(confirmUsername,newUsername,confirmUsername);
            if (isChecked){
                var userDTO = new RegisterDto();
                userDTO.setUserName(confirmUsername);
                boolean isUpdated = settingFormBO.updateCredential(userDTO);

                if (isUpdated){
                    new Alert(Alert.AlertType.INFORMATION,"Updated Successfully").show();
                }
            }
        }else if (!currentPassword.isEmpty() && !newPassword.isEmpty() && !confirmPassword.isEmpty()){

        }
    }

    private boolean checkingUsername(String currentUsername , String newUsername , String confirmUsername) {
        boolean isChecked = false;
        List<RegisterDto> registerUsers = settingFormBO.getAllUser();

        for (int i = 0; i < registerUsers.size(); i++){
            if (currentUsername.equals(registerUsers.get(i).getUserName())){
                if (newUsername.equals(confirmUsername)){
                    isChecked = true;
                }else {
                   new Alert(Alert.AlertType.ERROR).show();
                }
            }
        }
        return isChecked;
    }


    }

