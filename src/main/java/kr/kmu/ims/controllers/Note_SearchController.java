package kr.kmu.ims.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.kmu.ims.models.Customer;
import kr.kmu.ims.models.Employee;
import kr.kmu.ims.models.Goods;
import kr.kmu.ims.repositories.CustomerRepository;
import kr.kmu.ims.repositories.EmployeeRepository;
import kr.kmu.ims.repositories.Note_SearchRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Note_SearchController {

    @FXML
    private TextField searchIdText;
    @FXML
    private TableView GoodsTable;

    private final String viewPath = "/kr/kmu/ims/views/";


    public void showDialog(final String viewName, String title) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(viewPath+viewName));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchGoods(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Goods> data = Note_SearchRepository.searchGoods();

            //Populate Employees on TableView
            populateGoods(data);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    private void populateGoods(ObservableList<Goods> data) throws ClassNotFoundException {
        //Set items to the employeeTable
        GoodsTable.setItems(data);
    }

    @FXML
    public void DetailBtnClick(ActionEvent actionEvent) throws IOException {

        showDialog("hello-view.fxml", "note_detail");
    }
}