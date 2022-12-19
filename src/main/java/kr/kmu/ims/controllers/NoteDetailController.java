package kr.kmu.ims.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import kr.kmu.ims.models.Customer;
import kr.kmu.ims.models.Employee;
import kr.kmu.ims.models.Goods;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public TextField AdjOty;

    public DatePicker StatusDate;
    public TextField Status;
    public DatePicker CurDate;
    @FXML
    private TextField searchIdText;
    @FXML
    private TextField reasonText;
    @FXML
    private TextField locationText;


    @FXML
    private TableView NoteDetailTable;
    @FXML
    public TableColumn<NoteDetail, Integer> GOODS_ADJUSTMENT_NOTE_DETAIL_ID;
    @FXML
    public TableColumn<NoteDetail, String> GoodsItemCode;;
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
    private DatePicker AdjDate;
//--------------------------------------------------------

    //Delete button

    @FXML
    private TextField ReasonText;
//--------------------------------------------------------




    //---------------------------------------------------
    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.

    @FXML
    private void initialize () {


        //For multithreading: Create executor that uses daemon threads:
        exec = Executors.newCachedThreadPool((runnable) -> {
            Thread t = new Thread (runnable);
           t.setDaemon(true);
            return t;
        });


        GOODS_ADJUSTMENT_NOTE_DETAIL_ID.setCellValueFactory(cellData -> (cellData.getValue().Goods_adjustment_note_detail_id_Property().asObject()));
        GoodsItemCode.setCellValueFactory(cellData -> cellData.getValue().Item_code_Property());
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
    @FXML
    private void searchNote (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            ObservableList<NoteDetail> data=NoteDetailRepository.searchNoteDetail(IdText.getText());

            populateNoteDetail(data);
        } catch (SQLException e) {
            e.printStackTrace();

            throw e;
        }
    }
    private void populateAndShowNoteDetail(NoteDetail noteDetail) throws ClassNotFoundException {
        if (noteDetail != null) {
            populateNote(noteDetail);
            //setEmpInfoToTextArea(emp);
        } else {
            //resultArea.setText("This employee does not exist!\n");
        }
    }
    @FXML
    private void populateNote (NoteDetail noteDetail) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<NoteDetail> noteDetailsData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        noteDetailsData.add(noteDetail);
        //Set items to the employeeTable
        NoteDetailTable.setItems(noteDetailsData);
    }

    @FXML
    private void Save_NoteDetail (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        //try {
          //  NoteDetailRepository.updateLocation(locationText.getText(), reasonText.getText());
            ////resultArea.setText("Email has been updated for, employee id: " + empIdText.getText() + "\n");
        //} catch (SQLException e) {
            //resultArea.setText("Problem occurred while updating email: " + e);
        //}
        String ID = IdText.textProperty().getValue();

        try {
            //add new employee
            NoteDetailRepository.Report( ID, CurDate.getEditor().toString(), Reason.getText(), Status.getText());
            //resultArea.setText("Employee inserted! \n");

            //reload all records
            searchNote(actionEvent);
        } catch (SQLException e) {
            //resultArea.setText("Problem occurred while inserting employee " + e);
            throw e;
        }
    }

    public void Delete_NoteDetail(ActionEvent actionEvent) {
        try {

            NoteDetailRepository.deleteAdjWithCode(ItemCode.getText());
        } catch (Exception e) {
            ReasonText.setText("Problem occurred while deleting Goods " + e);
        }
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
        String adjOty = AdjOty.textProperty().getValue();
        String location = Location.textProperty().getValue();
        String reason = Reason.textProperty().getValue();

        NoteDetailRepository.insertAddGoods(GanId, itemId, itemCode, description, adjOty,location, reason);
    }


    public void SetganID(String ID)
    {
        IdText.setText(ID);
    }
    public void StatusDate(String Date)
    {
        StatusDate.getEditor().setText(Date);

    }
    public void AdjDate(String Date)
    {
        CurDate.getEditor().setText(Date);
    }
    public void Status(String status)
    {
        Status.setText(status);
    }


    public void CloseBtn(ActionEvent actionEvent) {
        System.exit(0);
    }
}
