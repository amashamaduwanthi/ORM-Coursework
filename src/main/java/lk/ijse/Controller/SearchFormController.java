package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.ijse.BO.Custom.BookBO;
import lk.ijse.BO.Custom.BorrowBookBO;
import lk.ijse.BO.Custom.PersonBO;
import lk.ijse.BOFactory.BOFactory;
import lk.ijse.DTO.BookDTO;
import lk.ijse.DTO.PersonDTO;
import lk.ijse.Entity.Person;

import java.io.IOException;
import java.sql.SQLException;

public class SearchFormController {
    public TextField txtID;
    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblBookName;

    @FXML
    private Label lblName;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblGenre;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtUsername;
    BorrowBookBO borrowBookBo = (BorrowBookBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.BORROWBOOK);
    PersonBO personBO = (PersonBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.PERSON);
    BookBO bookBo = (BookBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.BOOK);

    @FXML
    void btnBorrowOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/confirm_card.fxml"));
        Parent rootNode = loader.load();

        Scene scene = new Scene(rootNode);

        Stage stage = new Stage();
        stage.setTitle("Book Worm");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnConfirmOnAction(ActionEvent event) {
        String title = txtTitle.getText();
        String userName = txtUsername.getText();
        String id = txtID.getText();
        try {
            BookDTO book = bookBo.searchBook(title);
            PersonDTO userDto = personBO.getUserId(userName);

            if (userDto != null) {
                boolean success = borrowBookBo.placeBorrow(convertToUser(userDto), book,id);
                if (success) {
                    clearFields();
                    new Alert(Alert.AlertType.CONFIRMATION,"Book borrowed successfull").show();
                } else {
                    clearFields();
                    new Alert(Alert.AlertType.ERROR,"Book borrow Unsuccessfull").show();
                }
            } else {
                clearFields();
                new Alert(Alert.AlertType.ERROR,"Please log into Borrow a Book").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"An Error occurred when borrowing the book").show();
        }
    }

    private Person convertToUser(PersonDTO userDto) {
        if(userDto == null){
            return null;
        }

        Person user = new Person();
        user.setuId(userDto.getuId());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setConfirmPassword(userDto.getConfirmPassword());

        return user;
    }

    public void searchBookDetails(BookDTO bookDto) {
        lblName.setText(bookDto.getTitle());
        lblBookId.setText(bookDto.getbId());
        lblBookName.setText(bookDto.getTitle());
        lblAuthor.setText(bookDto.getAuthor());
        lblGenre.setText(bookDto.getGenre());
        lblStatus.setText(bookDto.getStatus());
    }

    private void clearFields() {
        txtTitle.setText("");
        txtUsername.setText("");
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }
}
