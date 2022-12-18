package kr.kmu.ims.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import kr.kmu.ims.models.Customer;
import kr.kmu.ims.models.Employee;
import kr.kmu.ims.repositories.CustomerRepository;
import kr.kmu.ims.repositories.EmployeeRepository;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import kr.kmu.ims.models.NoteDetail;
import kr.kmu.ims.repositories.NoteDetailRepository;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class NoteDetailController {

    @FXML
    private final String viewPath = "/kr/kmu/ims/views/";
    public TextField ItemID;
    public TextField ItemCode;
    public TextArea Description;
    public TextArea Location;
    public TextField Reason;
    public Button AddLineItem;
    public TextField Gan;


    @FXML
    private TextField searchIdText;
    @FXML
    private TableView NoteDetailTable;
    @FXML
    public TableColumn<NoteDetail, Integer> GOODS_ADJUSTMENT_NOTE_DETAIL_ID;
    @FXML
    public TableColumn<NoteDetail, Integer> GOODS_ADJUSTMENT_NOTE_ID_;;
    public TableColumn<NoteDetail, String> ITEM_DESCRIPTION;
    public TableColumn<NoteDetail, String> LOCATION;;
    public TableColumn<NoteDetail, String> UOM;
    public TableColumn<NoteDetail, Double> ADJUSTMENT_QTY;
    public TableColumn<NoteDetail, String> ADJUSTMENT_REASON;



    //For MultiThreading
    private Executor exec;

//--------------------------------------------------------
    //Finalize button
    @FXML
    private Button FinalBtn;
    @FXML
    private TextField IdText;
//--------------------------------------------------------
    //additem







    //-------------------------------------------------------------------
    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.

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
            Thread t = new Thread (runnable);
           t.setDaemon(true);
            return t;
        });


        //GOODS_ADJUSTMENT_NOTE_ID.setCellValueFactory(new PropertyValueFactory<>("goodsAdjustmentNoteIdProperty"));
        //the above line is also a way to show data.

        GOODS_ADJUSTMENT_NOTE_DETAIL_ID.setCellValueFactory(cellData -> (cellData.getValue().Goods_adjustment_note_detail_id_Property().asObject()));
        GOODS_ADJUSTMENT_NOTE_ID_.setCellValueFactory(cellData -> cellData.getValue().Goods_adjustment_note_id_Property().asObject());
        ITEM_DESCRIPTION.setCellValueFactory(cellData-> (cellData.getValue().Item_description_Property()));
        LOCATION.setCellValueFactory(cellData->cellData.getValue().LocationProperty());
        UOM.setCellValueFactory(cellDate->(cellDate.getValue().UomProperty()));
        ADJUSTMENT_QTY.setCellValueFactory(cellData->(cellData.getValue().AdjustmentQty.asObject()));
        ADJUSTMENT_REASON.setCellValueFactory(cellData->(cellData.getValue().AdjustmentReasonProperty()));


    }


    @FXML
    private void searchNoteDetail(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<NoteDetail> data = NoteDetailRepository.searchNote();

            //Populate Employees on TableView
            populateNoteDetail(data);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }



    @FXML
    private void populateNoteDetail(ObservableList<NoteDetail> data) throws ClassNotFoundException {
        //Set items to the employeeTable

        NoteDetailTable.setItems(data);


        System.out.println(data.get(0).get_Goods_adjustment_note_detail_id());
        System.out.println(data.get(0).get_Goods_adjustment_note_id());
    }

    public void Save_NoteDetail(ActionEvent actionEvent) {
    }

    public void Delete_NoteDetail(ActionEvent actionEvent) {
    }


    @FXML
    public void FinalBtnClick(ActionEvent actionEvent)
    {
        //해야하는 일...
        //1. GOODS_ADJUSTMENT_NOTE에 값을 Status =“finalized”
        //2 Status Date=Current date time
        //3 Is Finalized=True

        String ID = IdText.textProperty().getValue();
        try {
            System.out.print("ID : "+ ID);

            NoteDetailRepository.FinalizeUpdateDB(ID);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void AddItemDetail(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        //아이템 추가
        String GanId = Gan.textProperty().getValue();
        String itemId = ItemID.textProperty().getValue();
        String itemCode = ItemCode.textProperty().getValue();
        String description = Description.textProperty().getValue();
        String location = Location.textProperty().getValue();
        String reason = Reason.textProperty().getValue();

        NoteDetailRepository.insertAddGoods(GanId, itemId, itemCode, description, location, reason);
    }
}
