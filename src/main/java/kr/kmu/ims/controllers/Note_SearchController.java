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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.kmu.ims.models.Goods;
import kr.kmu.ims.models.Customer;
import kr.kmu.ims.models.Employee;
import kr.kmu.ims.models.Goods;
import kr.kmu.ims.repositories.CustomerRepository;
import kr.kmu.ims.repositories.EmployeeRepository;
import kr.kmu.ims.repositories.Note_SearchRepository;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Note_SearchController {

    @FXML
    private final String viewPath = "/kr/kmu/ims/views/";
    @FXML
    private TextField searchIdText;


    @FXML
    private TableView GoodsTable;
    @FXML
    public TableColumn<Goods, Integer> GOODS_ADJUSTMENT_NOTE_ID;
    @FXML
    public  TableColumn<Goods, String> DOCUMENT_NO;
    @FXML
    public TableColumn<Goods, Date> ADJUSTMENT_DATE;
    @FXML
    public TableColumn<Goods, String> TRANS_TYPE;
    @FXML
    public TableColumn<Goods, String> ADJUSTMENT_MODE;
    @FXML
    public TableColumn<Goods, String> ADJUSTMENT_REASON;
    @FXML
    public  TableColumn<Goods, Integer> STOREID;
    @FXML
    public TableColumn<Goods, String> REMARKS;
    @FXML
    public  TableColumn<Goods, Integer> CREATED_BY;
    @FXML
    public TableColumn<Goods, Date> CREATED_ON;
    @FXML
    public  TableColumn<Goods, Integer> LAST_UPDATED_BY;
    @FXML
    public TableColumn<Goods, Date> LAST_UPDATED_ON;
    @FXML
    public TableColumn<Goods, String> STATUS;
    @FXML
    public TableColumn<Goods, Date> STATUS_DATE;
    @FXML
    public  TableColumn<Goods, Integer> IS_FINALIZED;
    @FXML
    public  TableColumn<Goods, Integer> FINALIZED_BY;
    @FXML
    public TableColumn<Goods, Date> FINALIZED_ON;

    //For MultiThreading
    private Executor exec;
    @FXML
    private void initialize () {
        /*
        The setCellValueFactory(...) that we set on the table columns are used to determine
        which field inside the Employee objects should be used for the particular column.
        The arrow -> indicates that we're using a Java 8 feature called Lambdas.
        (Another option would be to use a PropertyValueFactory, but this is not type-safe

        We're only using StringProperty values for our table columns in this example.
        When you want to use IntegerProperty or DoubleProperty, the setCellValueFactory(...)
        must have an additional asObject():
        */


        //For multithreading: Create executor that uses daemon threads:
        exec = Executors.newCachedThreadPool((runnable) -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t;
        });

//        GOODS_ADJUSTMENT_NOTE_ID.setCellValueFactory(new PropertyValueFactory<>("goodsAdjustmentNoteIdProperty"));
        //the above line is also a way to show data.


        GOODS_ADJUSTMENT_NOTE_ID.setCellValueFactory(cellData -> cellData.getValue().goodsAdjustmentNoteIdProperty().asObject());
        DOCUMENT_NO.setCellValueFactory(cellData -> cellData.getValue().documentNoProperty());





        //add more of your fields here that we show in table.
        //ADJUSTMENT_DATE.setCellValueFactory(); .... do it ..
        //.. Thankyou.............nnn:)...
        //very Thankyou..
        //welcome.. if you need more help, i am awake, ping me again.
        //okay...........


    }



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


        System.out.println(data.get(0).getGoodsAdjustmentNoteId());
        System.out.println(data.get(0).getDocument_no());
        System.out.println(data.get(1).getGoodsAdjustmentNoteId());
        System.out.println(data.get(1).getDocument_no());
        System.out.println(data.get(2).getGoodsAdjustmentNoteId());
        System.out.println(data.get(2).getDocument_no());
        //GoodsTable.set

        //GoodsTable.getItems().clear();
    }

    @FXML
    public void DetailBtnClick(ActionEvent actionEvent) throws IOException {

        showDialog("hello-view.fxml", "note_detail");
    }
}