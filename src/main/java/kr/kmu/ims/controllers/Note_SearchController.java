package kr.kmu.ims.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import kr.kmu.ims.InventoryApplication;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javafx.util.Callback;
import kr.kmu.ims.models.*;

import kr.kmu.ims.models.Goods;
import kr.kmu.ims.repositories.NoteDetailRepository;
import kr.kmu.ims.repositories.Note_SearchRepository;

import java.io.IOException;

import java.sql.Date;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.text.SimpleDateFormat;

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
    public TableColumn<Goods, String> DOCUMENT_NO;
    @FXML
    public TableColumn<Goods, Date> ADJUSTMENT_DATE;
    @FXML
    public TableColumn<Goods, String> TRANS_TYPE;
    @FXML
    public TableColumn<Goods, String> ADJUSTMENT_MODE;
    @FXML
    public TableColumn<Goods, String> ADJUSTMENT_REASON;

    @FXML
    public TableColumn<Goods, String> REMARKS;

    @FXML
    public TableColumn<Goods, String> STATUS;

    @FXML
    public TableColumn<Goods, String> STATUS_Date;

    @FXML
    public TableColumn<Goods, Void> OpenButton;
    //For MultiThreading
    private Executor exec;


    @FXML
    private void initialize() {
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

        //GOODS_ADJUSTMENT_NOTE_ID.setCellValueFactory(new PropertyValueFactory<>("goodsAdjustmentNoteIdProperty"));
        //the above line is also a way to show data.


        GOODS_ADJUSTMENT_NOTE_ID.setCellValueFactory(cellData -> cellData.getValue().goodsAdjustmentNoteIdProperty().asObject());
        DOCUMENT_NO.setCellValueFactory(cellData -> cellData.getValue().documentNoProperty());
        ADJUSTMENT_DATE.setCellValueFactory(cellData -> cellData.getValue().adjustmentDateProperty());
        TRANS_TYPE.setCellValueFactory(cellData -> cellData.getValue().transTypeProperty());
        ADJUSTMENT_MODE.setCellValueFactory(cellData -> cellData.getValue().adjustmentModeProperty());
        ADJUSTMENT_REASON.setCellValueFactory(cellData -> cellData.getValue().adjustmentReasonProperty());
        REMARKS.setCellValueFactory(cellData -> cellData.getValue().remarksProperty());
        STATUS.setCellValueFactory(cellData -> cellData.getValue().status_Property());
        STATUS_Date.setCellValueFactory(cellData -> cellData.getValue().status_date_Property().asString());


        addButtonToTable();



    }

    public void showDialog(final String viewName, String title) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(viewPath + viewName));

            var controller = fxmlLoader.getController();

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


    public Object showDialogOpenButton(final String viewName, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(viewPath + viewName));

            var controller = fxmlLoader.getController();

            System.out.println("controller");
            System.out.println(controller);

            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(root));


            stage.show();
            return controller;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @FXML
    private void searchGoods(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Goods> data = Note_SearchRepository.searchGoods();

            populateGoods(data);


        } catch (SQLException e) {
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }


    @FXML
    private void populateGoods(ObservableList<Goods> data) throws ClassNotFoundException {

        GoodsTable.setItems(data);


    }


    private void addButtonToTable() {
        Callback<TableColumn<Goods, Void>, TableCell<Goods, Void>> cellFactory = new Callback<TableColumn<Goods, Void>, TableCell<Goods, Void>>() {
            @Override
            public TableCell<Goods, Void> call(final TableColumn<Goods, Void> param) {
                final TableCell<Goods, Void> cell = new TableCell<Goods, Void>() {

                    private final Button btn = new Button("Open");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Goods date_ = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + date_.getGoodsAdjustmentNoteId());
                            try {

                                SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String statusDate = afterFormat.format(date_.getStatus_date());

                                statusDate = statusDate.replace ( " " , "T" );

                             //   LocalDate localDate = LocalDate.parse(statusDate);
                               // System.out.println(statusDate);
                                showDetail(date_.getGoodsAdjustmentNoteId(),statusDate);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        OpenButton.setCellFactory(cellFactory);

    }




    @FXML
    public void DetailBtnClick(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
     //   showDialog("hello-view.fxml", "note_detail");
        NoteDetailController controller = (NoteDetailController) InventoryApplication.Instance.rootController.showTabOpenButton("hello-view.fxml", "note_detail");

    }

    public void showDetail(int id, String statusDate) throws SQLException, ClassNotFoundException, IOException {
        NoteDetailController controller = (NoteDetailController) InventoryApplication.Instance.rootController.showTabOpenButton("hello-view.fxml", "note_detail");

        controller.SetganID(String.valueOf(id));
        controller.StatusDate(statusDate);
    }


}



