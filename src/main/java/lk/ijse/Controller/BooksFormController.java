package lk.ijse.Controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.BO.Custom.LibraryBO;
import lk.ijse.BOFactory.BOFactory;
import lk.ijse.DTO.BookDTO;
import lk.ijse.DTO.TM.BookTM;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class BooksFormController {
    public AnchorPane bookPanel;
    public TextField txtName;
    public TextField txtAuthor;
    public JFXComboBox<String> cmbLibraryIds;
    public ComboBox<String> cmbGenre;
    public TableView<BookTM> tblBook;
    public TableColumn<BookDTO,String> colTitle;
    public TableColumn<BookDTO,String> colAuthor;
    public TableColumn<BookDTO,String> colGenre;
    public TableColumn<BookDTO,String> colStatus;
    public ComboBox cmbStatus;
    public TextField txtbookId;


    LibraryBO branchBO = (LibraryBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.LIBRARY);
    BookBO bookBO = (BookBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.BOOK);
    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if(validateBooks()){
            String id = txtbookId.getText();
            String title = txtName.getText();
            String author = txtAuthor.getText();
            String genre = cmbGenre.getValue();
            String status = String.valueOf(cmbStatus.getValue());

            var dto = new BookDTO(id,title,author,genre,status);

            try {
                boolean isSaved = bookBO.saveBook(dto);

                if(isSaved){

                    new Alert(Alert.AlertType.CONFIRMATION,"Book Saved Successfully").show();
                }else{
                    new Alert(Alert.AlertType.CONFIRMATION,"Book Saved Successfully").show();
                    clearFields();
                    loadAllBooks();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void clearFields() {
        txtName.setText("");
        txtAuthor.setText("");
        cmbGenre.setValue("");
        cmbStatus.setValue("");
    }

    public boolean validateBooks(){
        String title = txtName.getText();

        boolean isTitleValidated = Pattern.matches("[a-z][a-zA-Z\\s]+", title);
        if (!isTitleValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Title!").show();
            return false;
        }

        String author = txtAuthor.getText();

        boolean isAuthorValidated = Pattern.matches("[a-z][a-zA-Z\\s]+", title);
        if (!isAuthorValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Author!").show();
            return false;
        }

        String genre = cmbGenre.getValue();

        boolean isGenreValidated = Pattern.matches("Adventure|Novel|Thriller|Fiction|Historical|Fantasy|Poetry", genre);
        if (!isGenreValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Genre!").show();
            return false;
        }

        String status = String.valueOf(cmbStatus.getValue());

        boolean isStatusValidated = Pattern.matches("Available|Unavailable", status);
        if (!isStatusValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Status!").show();
            return false;
        }

        return true;
    }

    private void loadAllBooks(){
        ObservableList<BookTM> obList = FXCollections.observableArrayList();

        List<BookDTO> dtoList = bookBO.getAllBooks();

        for(BookDTO dto : dtoList){
            obList.add(new BookTM(
                    dto.getbId(),
                    dto.getTitle(),
                    dto.getAuthor(),
                    dto.getGenre(),
                    dto.getStatus()
            ));
        }
        tblBook.setItems(obList);
        tblBook.refresh();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        if(validateBooks()){
            String title = txtName.getText();
            String author =  txtAuthor.getText();
            String genre = cmbGenre.getValue();
            String status = String.valueOf(cmbStatus.getValue());

            BookDTO bookDto = new BookDTO(title,author,genre,status);

            try {
                boolean isUpdate = bookBO.updateBook(bookDto);

                if(isUpdate){
                    clearFields();
                    loadAllBooks();
                    new Alert(Alert.AlertType.CONFIRMATION,"Book Updated").show();
                }else{
                    new Alert(Alert.AlertType.ERROR,"Book Update Unsuccessfull").show();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String title = txtName.getText();

        try {
            boolean isDeleted = bookBO.deleteBook(title);

            if(isDeleted){
                clearFields();
                loadAllBooks();
                new Alert(Alert.AlertType.CONFIRMATION,"Book Deleted").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Book Deleting Unsuccessfull").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String title = txtName.getText();

        BookDTO bookDto = bookBO.searchBook(title);

        if(bookDto != null){
            txtAuthor.setText(bookDto.getAuthor());
            cmbGenre.setValue(bookDto.getGenre());
            cmbStatus.setValue(bookDto.getStatus());
        }else {
            new Alert(Alert.AlertType.ERROR,"Book Not Found").show();
        }
    }
    public void initialize() throws Exception {
        loadGenre();
        loadStatus();
        loadAllBooks();
        setCellValueFactory();
        tableListener();
    }

    private void loadGenre() {
        List<String> genre = Arrays.asList("Adventure", "Novel", "Thriller", "Fiction", "Historical", "Fantasy", "Poetry");
        ObservableList<String> genreList = FXCollections.observableArrayList(genre);
        cmbGenre.setItems(genreList);
    }

    private void loadStatus() {
        List<String> status = Arrays.asList("Available", "Unavailable");
        ObservableList<String> statusList = FXCollections.observableArrayList(status);
        cmbStatus.setItems(statusList);
    }

    private void tableListener() {
        tblBook.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);
        });
    }
    private void setData(Object newValue) {
    }
    private void setCellValueFactory(){
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }


}
