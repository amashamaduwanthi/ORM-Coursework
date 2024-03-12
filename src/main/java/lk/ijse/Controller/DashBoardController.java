package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoardController {
    public AnchorPane mainPanel;

    public void btnBookOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Book-Form.fxml"));
        mainPanel.getChildren().clear();
        mainPanel.getChildren().add(anchorPane);
    }

    public void btnPersonOnAtion(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/person-Form.fxml"));
        mainPanel.getChildren().clear();
        mainPanel.getChildren().add(anchorPane);
    }

    public void btnBranchersOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Branchers-Form.fxml"));
        mainPanel.getChildren().clear();
        mainPanel.getChildren().add(anchorPane);
    }
}
