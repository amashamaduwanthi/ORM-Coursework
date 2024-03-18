package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.Custom.BorrowBookBO;
import lk.ijse.BOFactory.BOFactory;
import lk.ijse.DTO.BorrowedBooksDto;
import lk.ijse.DTO.TM.BorrowBookTM;
import lk.ijse.Entity.Book;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class BookBorrowController {
    public AnchorPane borrowBookPanel;
    public TableView<BorrowBookTM> tblBorrowBook;
    public TableColumn<BorrowedBooksDto, LocalDateTime> colBorrowDate;
    public TableColumn<BorrowedBooksDto, LocalDateTime> colDueDate;
    public TableColumn<BorrowedBooksDto, Book> colBookId;
    public TableColumn <BorrowedBooksDto, JFXButton>colReturn;
    public Label lblBookTitle;
    public Label lblDate;
    public Label lblBorrowID;
    public Label availability;


    BorrowBookBO borrowBookBO = (BorrowBookBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.BORROWBOOK);

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/UserLogIn.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) borrowBookPanel.getScene().getWindow();
        stage.setScene(scene);
    }
    public void initialize(){
        tableListener();
        setCellValueFactory();
        loadAllBorrowedBooks();
    }
    private void tableListener() {
        tblBorrowBook.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);
        });
    }
    private void setData(BorrowBookTM newValue) {
    }
    private void loadAllBorrowedBooks(){
        ObservableList<BorrowBookTM> obList = FXCollections.observableArrayList();

        List<BorrowedBooksDto> dtoList = borrowBookBO.getAllBorrowedBooks();

        for(BorrowedBooksDto dto : dtoList){
            JFXButton btnReturn = new JFXButton("Return");

            btnReturn.setStyle("-fx-background-color: #e67e22; -fx-text-fill: white; -fx-font-weight: bold;");
            btnReturn.setCursor(Cursor.HAND);
            colReturn.setStyle("-fx-alignment: CENTER;");
            btnReturn.setMaxWidth(100.0);

            obList.add(new BorrowBookTM(
                    dto.getBorrowedDate(),
                    dto.getReturnDate(),
                    dto.getBookId(),
                    btnReturn
            ));
        }
        tblBorrowBook.setItems(obList);
        tblBorrowBook.refresh();
    }
    private void setCellValueFactory() {
        colBorrowDate.setCellValueFactory(new PropertyValueFactory<>("borrowedDate"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colReturn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("btnReturn"));
    }
}
