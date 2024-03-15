package lk.ijse.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.BO.Custom.LibraryBO;
import lk.ijse.BoFactory.BOFactory;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Dto.LibraryDTO;
import lk.ijse.Dto.TM.BookTM;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.Library;

import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class BookFormController {

    public AnchorPane BookPanel;
    public TextField txtTitle;
    public TextField txtAuthor;
    public TextField txtGenre;
    public TextField txtStatus;
    public TextField TXTID;
    public TableView tblBooks;
    public TableColumn colId;
    public TableColumn ColName;
    public TableColumn colAuthor;
    public TableColumn ColGenre;
    public TableColumn colYear;
    public TableColumn colQty;
    public TableColumn colBranch;
    public Label branchName;
    public ComboBox cmbbranchID;
    public Label lblId;
    public TableColumn colTitle;
    public TableColumn colGenre;
    public TableColumn colStatus;
    public ComboBox cmbGenre;
    public ComboBox cmbStatus;

    BookBO bookBO = (BookBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.BOOK);
    LibraryBO libraryBO = (LibraryBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.LIBRARY);


    public void btnUpdateOnAction(ActionEvent actionEvent) {
        if (validateBooks()) {
            String title = txtTitle.getText();
            String author = txtAuthor.getText();
            String genre = (String) cmbGenre.getValue();
            String status = (String) cmbStatus.getValue();

            BookDTO bookDto = new BookDTO(title, author, genre, status);

            try {
                boolean isUpdate = bookBO.updateBook(bookDto);

                if (isUpdate) {
                    clearFields();
                    loadAllBooks();
                    new Alert(Alert.AlertType.CONFIRMATION, "Book Updated").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Book Update Unsuccessfull").show();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException {
        String title = txtTitle.getText();

        boolean isDeleted = bookBO.deleteBook(title);

        if (isDeleted) {
            clearFields();
            loadAllBooks();
            new Alert(Alert.AlertType.CONFIRMATION, "Book Deleted").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Book Deleting Unsuccessfull").show();
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String title = txtTitle.getText();

        BookDTO bookDto = bookBO.existsBook(title);

        if (bookDto != null) {
            txtAuthor.setText(bookDto.getAuthor());
            cmbGenre.setValue(bookDto.getGenre());
            cmbStatus.setValue(bookDto.getStatus());
        } else {
            new Alert(Alert.AlertType.ERROR, "Book Not Found").show();
        }
    }


    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (validateBooks()) {
            String title = txtTitle.getText();
            String author = txtAuthor.getText();
            String genre = (String) cmbGenre.getValue();
            String status = (String) cmbStatus.getValue();

            var dto = new BookDTO(title, author, genre, status);

            try {
                boolean isSaved = bookBO.saveBook(dto);

                if (isSaved) {
                    clearFields();
                    loadAllBooks();
                    new Alert(Alert.AlertType.CONFIRMATION, "Book Saved Successfully").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Book Save Unsuccessfull").show();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private boolean validateBooks() {
        String title = txtTitle.getText();

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

        String genre = (String) cmbGenre.getValue();

        boolean isGenreValidated = Pattern.matches("Adventure|Novel|Thriller|Fiction|Historical|Fantasy|Poetry", genre);
        if (!isGenreValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Genre!").show();
            return false;
        }

        String status = (String) cmbStatus.getValue();

        boolean isStatusValidated = Pattern.matches("Available|Unavailable", status);
        if (!isStatusValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Status!").show();
            return false;
        }

        return true;
    }



    private void loadAllBooks() {
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
        tblBooks.setItems(obList);
        tblBooks.refresh();

    }

    private void clearFields() {
        txtTitle.setText("");
        txtAuthor.setText("");
        cmbGenre.setValue("");
        cmbStatus.setValue("");

    }

    //-------------------------------------------------------------------------------------------------------------

    public void initialize() {
        loadGenre();
        loadStatus();
        tableListener();
        loadAllBooks();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void tableListener() {
        tblBooks.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(Object newValue) {
    }


    private void loadStatus() {
        List<String> status = Arrays.asList("Available", "Unavailable");
        ObservableList<String> statusList = FXCollections.observableArrayList(status);
        cmbStatus.setItems(statusList);

    }

    private void loadGenre() {
        List<String> genre = Arrays.asList("Adventure", "Novel", "Thriller", "Fiction", "Historical", "Fantasy", "Poetry");
        ObservableList<String> genreList = FXCollections.observableArrayList(genre);
        cmbGenre.setItems(genreList);

    }


}
