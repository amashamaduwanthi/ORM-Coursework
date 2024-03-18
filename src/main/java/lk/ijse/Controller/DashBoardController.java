package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardController {
    public AnchorPane MainPanel;

    public void btnManageBooksOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Book-Form.fxml"));
        MainPanel.getChildren().clear();
        MainPanel.getChildren().add(anchorPane);
    }

    public void btnManagePersonsOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Person-form.fxml"));
        MainPanel.getChildren().clear();
        MainPanel.getChildren().add(anchorPane);
    }

    public void btnManageLibraiesOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Branchers-Form.fxml"));
        MainPanel.getChildren().clear();
        MainPanel.getChildren().add(anchorPane);
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/login-Form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) MainPanel.getScene().getWindow();
        stage.setScene(scene);
    }
}
