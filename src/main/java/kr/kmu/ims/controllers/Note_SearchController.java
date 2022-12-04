package kr.kmu.ims.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import kr.kmu.ims.models.Customer;
import kr.kmu.ims.models.Employee;
import kr.kmu.ims.models.Goods;
import kr.kmu.ims.repositories.CustomerRepository;
import kr.kmu.ims.repositories.EmployeeRepository;
import kr.kmu.ims.repositories.Note_SearchRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Note_SearchController {

    @FXML
    private TextField searchIdText;
    @FXML
    private TableView GoodsTable;

    @FXML
    private void searchGoods(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Goods> data = Note_SearchRepository.searchGoods();

            //Populate Employees on TableView
            populateGoods(data);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML
    private void populateGoods ( ObservableList<Goods> data) throws ClassNotFoundException {
        //Set items to the employeeTable
        GoodsTable.setItems(data);
    }

}
