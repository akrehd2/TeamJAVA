package kr.kmu.ims.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import kr.kmu.ims.models.Customer;
import kr.kmu.ims.models.Employee;
import kr.kmu.ims.repositories.CustomerRepository;
import kr.kmu.ims.repositories.EmployeeRepository;
import kr.kmu.ims.repositories.NoteDetailRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NoteDetailController {

    @FXML
    private TextField searchIdText;
    @FXML
    private TextArea resultArea;


    @FXML
    private TextField idText;
    @FXML
    private TextField nameText;

    @FXML
    private TableView customerTable;
    @FXML
    private TableColumn<Customer, Integer> idColumn;
    @FXML
    private TableColumn<Customer, String>  nameColumn;

    //For MultiThreading
    private Executor exec;

//--------------------------------------------------------
    //Finalize button
    @FXML
    private Button FinalBtn;
    @FXML
    private TextField IdText;
//--------------------------------------------------------
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

      //  idColumn.setCellValueFactory(cellData -> cellData.getValue().customerIdProperty().asObject());
      //  nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

    }


    //Search an employee
    @FXML
    private void searchCustomer (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get Employee information
            Customer cust = CustomerRepository.searchCustomer(searchIdText.getText());
            //Populate Employee on TableView and Display on TextArea
            populateAndShowCustomer(cust);
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error occurred while getting employee information from DB.\n" + e);
            throw e;
        }
    }

    //Search all employees
    @FXML
    private void searchCustomers(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Customer> data = CustomerRepository.searchCustomers();
            //Populate Employees on TableView
            populateCustomerss(data);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }

    //Populate Employees for TableView with MultiThreading (This is for example usage)
    private void fillCustomerTable(ActionEvent event) throws SQLException, ClassNotFoundException {
        Task<List<Employee>> task = new Task<List<Employee>>(){
            @Override
            public ObservableList<Employee> call() throws Exception{
                return EmployeeRepository.searchEmployees();
            }
        };

        task.setOnFailed(e-> task.getException().printStackTrace());
        task.setOnSucceeded(e-> customerTable.setItems((ObservableList<Employee>) task.getValue()));
        exec.execute(task);
    }

    //Populate Employee
    @FXML
    private void populateCustomers (Customer customer) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Customer> data = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        data.add(customer);
        //Set items to the employeeTable
        customerTable.setItems(data);
    }

    //Set Employee information to Text Area
    @FXML
    private void setInfoToTextArea ( Customer cust) {
        resultArea.setText("Name: " + cust.getName()  );
    }

    //Populate Employee for TableView and Display Employee on TextArea
    @FXML
    private void populateAndShowCustomer(Customer c) throws ClassNotFoundException {
        if (c != null) {
            populateCustomers(c);
            setInfoToTextArea(c);
        } else {
            resultArea.setText("This employee does not exist!\n");
        }
    }

    //Populate Employees for TableView
    @FXML
    private void populateCustomerss (ObservableList<Customer> data) throws ClassNotFoundException {
        //Set items to the employeeTable
        customerTable.setItems(data);
    }

    //Update employee's email with the email which is written on newEmailText field
    @FXML
    private void updateCustomer(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            CustomerRepository.updateCustomer(idText.getText(), nameText.getText());
            resultArea.setText("updated for, cust id: " + idText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while updating email: " + e);
        }
    }

    //Insert an employee to the DB
    @FXML
    private void insertCustomer(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //add new employee
            CustomerRepository.insertCustomer(idText.getText(), nameText.getText());
            resultArea.setText("customer inserted! \n");

            //reload all records
            searchCustomers(actionEvent);
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while inserting employee " + e);
            throw e;
        }
    }

    //Delete an employee with a given employee Id from DB
    @FXML
    private void deleteCustomer (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            CustomerRepository.deleteCustomer(searchIdText.getText());
            resultArea.setText("customer deleted!  id: " + searchIdText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while deleting employee " + e);
            throw e;
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
}
