package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.BoFactory.BOFactory;
import lk.ijse.Dto.BookDTO;

import java.io.IOException;

public class UserSearchForm {
    public TextField txtTitle;
    BookBO bookBO = (BookBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.BOOK);
    public void btnSearchOnAction(ActionEvent actionEvent) {
        String title = txtTitle.getText();

        try{
            BookDTO bookDto = bookBO.searchBook(title);

            if(bookDto != null){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/search_form.fxml"));
                Parent rootNode = loader.load();

                BookBorrowController detailsController = loader.getController();

                detailsController.searchBookDetails(bookDto);

                Scene scene = new Scene(rootNode);

                Stage stage = new Stage();
                stage.setTitle("Book Worm");
                stage.setScene(scene);
                stage.show();

                clearFields();
            }else {
                new Alert(Alert.AlertType.ERROR,"Book Not Found").show();
            }
        }catch(IOException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }

    private void clearFields() {
        txtTitle.setText("");
    }
}
