package lk.ijse.Controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import lk.ijse.BO.Custom.LibraryBO;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.BOFactory.BOFactory;
import lk.ijse.DTO.BranchDTO;
import lk.ijse.DTO.TM.BranchTM;
import lk.ijse.DTO.UserDTO;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LibraryFormController {
    public TextField txtId;
    public TextField txtAddress;
    public ComboBox<String> cmbStatus;
    public ComboBox<String> cmbAdmin;
    public TableView<BranchTM> tblBranch;
    public TableColumn<BranchDTO, String> colLibraryID;
    public TableColumn<BranchDTO, String> colAddress;
    public TableColumn<BranchDTO, String> colQty;
    public TableColumn<BranchDTO, String> colStatus;
    public TableColumn<BranchDTO, String> colAdminID;
    public TextField txtBookQty;


    LibraryBO libraryBO = (LibraryBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.LIBRARY);
    UserBO userBO = (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.USER);

    public void btnAddOnAction(ActionEvent actionEvent) {
        if (validateBranch()) {
            String id = txtId.getText();
            String address = txtAddress.getText();
            String noBooks = txtBookQty.getText();
            String status = cmbStatus.getValue();
            String adminId = cmbAdmin.getValue();

            var dto = new BranchDTO(id, address, noBooks, status, adminId);

            try {
                boolean isSaved = libraryBO.saveBranch(dto);
                if (isSaved) {
                    // clearFields();
                    loadAllBranches();
                    new Alert(Alert.AlertType.CONFIRMATION, "Branch Saved").show();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean validateBranch() {
//        String id = txtId.getText();
//
//        boolean isIdValidated = Pattern.matches("B-[0-9]{3,}", id);
//        if (!isIdValidated) {
//            new Alert(Alert.AlertType.ERROR, "Invalid ID!").show();
//            return false;
//        }

        String address = txtAddress.getText();

        boolean isAddressValidated = Pattern.matches("[a-z][a-zA-Z\\s]+", address);
        if (!isAddressValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Address!").show();
            return false;
        }

//        String noBooks = txtBookQty.getText();
//
//        boolean isNoBooksValidated = Pattern.matches("\\d*", noBooks);
//        if (!isNoBooksValidated) {
//            new Alert(Alert.AlertType.ERROR, "Invalid Book Number!").show();
//            return false;
//        }

        String status = cmbStatus.getValue();

        boolean isStatusValidated = Pattern.matches("Open|Close", status);
        if (!isStatusValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Status!").show();
            return false;
        }

//        String adminId = cmbAdmin.getValue();
//
//        boolean isAdminIdValidated = Pattern.matches("A-[0-9]{3,}", adminId);
//        if (!isAdminIdValidated) {
//            new Alert(Alert.AlertType.ERROR, "Invalid Admin ID!").show();
//            return false;
//        }
//
       return true;
    }



    public void btnUpdateOnAction(ActionEvent actionEvent) {
        if (validateBranch()) {
            String id = txtId.getText();
            String address = txtAddress.getText();
            String bNumber = txtBookQty.getText();
            String status = cmbStatus.getValue();
            String adminId = cmbAdmin.getValue();

            BranchDTO branchDto = new BranchDTO(id, address, bNumber, status, adminId);

            try {
                boolean isUpdated = libraryBO.updateBranch(branchDto);
                if (isUpdated) {
                    //clearFields();
                    loadAllBranches();
                    new Alert(Alert.AlertType.CONFIRMATION, "Branch Updated").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Branch Update Unsuccessfull").show();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void loadStatus() {
        List<String> status = Arrays.asList("Open", "Close");
        ObservableList<String> statusList = FXCollections.observableArrayList(status);
        cmbStatus.setItems(statusList);
    }
    public void initialize(){
        loadAllBranches();
        loadStatus();
        loadAllAdminId();
    }
    private void loadAllAdminId(){
        ObservableList<String> obList = FXCollections.observableArrayList();

        List<UserDTO> idList = userBO.getAllAdmin();

        for(UserDTO adminDto : idList){
            obList.add(adminDto.getUserName());
        }
        cmbAdmin.setItems(obList);
    }

    private void loadAllBranches() {
        ObservableList<BranchTM> obList = FXCollections.observableArrayList();

        List<BranchDTO> dtoList = libraryBO.getAllBranches();

        for (BranchDTO dto : dtoList) {
            obList.add(new BranchTM(
                    dto.getbId(),
                    dto.getAddress(),
                    dto.getbNumber(),
                    dto.getStatus(),
                    dto.getAdminId()
            ));
        }
        tblBranch.setItems(obList);
        tblBranch.refresh();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();

        try {
            boolean isDeleted = libraryBO.deleteBranch(id);

            if (isDeleted) {
                //clearFields();
                loadAllBranches();
                new Alert(Alert.AlertType.CONFIRMATION, "Branch Deleted").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Branch Deleting Unsuccessfull").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();

        BranchDTO dto = libraryBO.search(id);

        if (dto != null) {
            txtAddress.setText(dto.getAddress());
            txtBookQty.setText(dto.getbNumber());
            cmbStatus.setValue(dto.getStatus());
            cmbAdmin.setValue(dto.getAdminId());
            cmbAdmin.setValue(dto.getAdminId());
        }
    }
}
