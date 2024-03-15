package lk.ijse.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.BO.Custom.LibraryBO;
import lk.ijse.BO.Custom.PersonBO;
import lk.ijse.BoFactory.BOFactory;
import lk.ijse.Dto.AdminDTO;
import lk.ijse.Dto.LibraryDTO;
import lk.ijse.Dto.TM.LibraryTM;
import lk.ijse.Entity.Library;

import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class BrancherFormController {
    public TextField txtLibraryId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtTel;
    public AnchorPane BranchesPanel;
    public TextField txtCount;
    public ComboBox cmbStatus;
    public ComboBox cmbAdmin;
    public TableView tblBranches;
    public TableColumn colId;
    public TableColumn colAddress;
    public TableColumn colCount;
    public TableColumn colStatus;
    public TableColumn colAdmin;
    LibraryBO libraryBO = (LibraryBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.LIBRARY);
    PersonBO personBO = (PersonBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.PERSON);

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException {
        if (validateBranch()) {
            String id = txtLibraryId.getText();
            String address = txtAddress.getText();
            String noBooks = txtCount.getText();
            String status = (String) cmbStatus.getValue();
            String adminId = (String) cmbAdmin.getValue();

            var dto = new LibraryDTO(id, address, noBooks, status, adminId);

            boolean isSaved = libraryBO.saveBranch(dto);
            if (isSaved) {
                clearFields();
                loadAllBranches();
                new Alert(Alert.AlertType.CONFIRMATION, "Branch Saved").show();
            }
        }
    }

    private void loadAllBranches() {
        ObservableList<LibraryTM> obList = FXCollections.observableArrayList();

        List<LibraryDTO> dtoList = libraryBO.getAllBranches();

        for(LibraryDTO dto : dtoList){
            obList.add(new LibraryTM(
                    dto.getbId(),
                    dto.getAddress(),
                    dto.getbNumber(),
                    dto.getStatus(),
                    dto.getAdminId()
            ));
        }
        tblBranches.setItems(obList);
        tblBranches.refresh();

    }

    private void clearFields() {
        txtLibraryId.setText("");
        txtAddress.setText("");
        txtCount.setText("");
        cmbAdmin.setValue("");
        cmbStatus.setValue("");

    }

    private boolean validateBranch() {
        String id = txtLibraryId.getText();

        boolean isIdValidated = Pattern.matches("B-[0-9]{3,}", id);
        if (!isIdValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid ID!").show();
            return false;
        }

        String address = txtAddress.getText();

        boolean isAddressValidated = Pattern.matches("[a-z][a-zA-Z\\s]+", address);
        if (!isAddressValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Address!").show();
            return false;
        }

        String noBooks = txtCount.getText();

        boolean isNoBooksValidated = Pattern.matches("\\d*", noBooks);
        if (!isNoBooksValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Book Number!").show();
            return false;
        }

        String status = (String) cmbStatus.getValue();

        boolean isStatusValidated = Pattern.matches("Open|Close", status);
        if (!isStatusValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Status!").show();
            return false;
        }

        String adminId = (String) cmbAdmin.getValue();

        boolean isAdminIdValidated = Pattern.matches("A-[0-9]{3,}", adminId);
        if (!isAdminIdValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Admin ID!").show();
            return false;
        }

        return true;
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException {
        if (validateBranch()) {
            String id = txtLibraryId.getText();
            String address = txtAddress.getText();
            String bNumber = txtCount.getText();
            String status = (String) cmbStatus.getValue();
            String adminId = (String) cmbAdmin.getValue();

            LibraryDTO branchDto = new LibraryDTO(id, address, bNumber, status, adminId);

            boolean isUpdated = libraryBO.updateBranch(branchDto);
            if (isUpdated) {
                clearFields();
                loadAllBranches();
                new Alert(Alert.AlertType.CONFIRMATION, "Branch Updated").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Branch Update Unsuccessfull").show();
            }
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String id = txtLibraryId.getText();

        LibraryDTO dto = (LibraryDTO) libraryBO.search(id);

        if (dto != null) {
            txtAddress.setText(dto.getAddress());
            txtCount.setText(dto.getbNumber());
            cmbStatus.setValue(dto.getStatus());
            cmbAdmin.setValue(dto.getAdminId());
            cmbAdmin.setValue(dto.getAdminId());
        }
    }
    public void initialize() {
        loadAllAdminId();
        loadStatus();
        loadAllBranches();
        setCellValueFactory();
        tableListener();
    }

    private void tableListener() {
        tblBranches.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(Object newValue) {
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("bId"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCount.setCellValueFactory(new PropertyValueFactory<>("bNumber"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colAdmin.setCellValueFactory(new PropertyValueFactory<>("adminId"));
    }



    private void loadStatus() {
        List<String> status = Arrays.asList("Open", "Close");
        ObservableList<String> statusList = FXCollections.observableArrayList(status);
        cmbStatus.setItems(statusList);

    }

    private void loadAllAdminId() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        List<AdminDTO> idList = personBO.getAllAdmin();

        for(AdminDTO adminDto : idList){
            obList.add(String.valueOf(adminDto.getId()));
        }
        cmbAdmin.setItems(obList);


    }

}