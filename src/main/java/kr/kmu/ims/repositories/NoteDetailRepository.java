package kr.kmu.ims.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kr.kmu.ims.models.Customer;
import kr.kmu.ims.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteDetailRepository {

    //*******************************
    //SELECT a Customer
    //*******************************
    public static Customer searchCustomer (String id) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM customers WHERE cust_id="+id;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getCustomerFromResultSet method and get customer object
            Customer customer = getCustomerFromResultSet(rs);

            //Return customer object
            return customer;
        } catch (SQLException e) {
            System.out.println("While searching a customer with " + id + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Customer Object's attributes and return customer object.
    private static Customer getCustomerFromResultSet(ResultSet rs) throws SQLException
    {
        Customer cust = null;
        if (rs.next()) {
            cust = new Customer();
            cust.setCustomerId(rs.getInt("CUST_ID"));
            cust.setName     (rs.getString( "NAME"));
        }
        return cust;
    }

    //*******************************
    //SELECT Customers
    //*******************************
    public static ObservableList<Customer> searchCustomers () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM customers";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getCustomerList method and get customer object
            ObservableList<Customer> list = getCustomerList(rs);

            //Return customer object
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from customers operation
    private static ObservableList<Customer> getCustomerList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Customer objects
        ObservableList<Customer> empList = FXCollections.observableArrayList();

        while (rs.next()) {
            Customer emp = new Customer();
            emp.setCustomerId(rs.getInt("CUST_ID"));
            emp.setName(rs.getString("NAME"));

            empList.add(emp);
        }
        //return empList (ObservableList of Customers)
        return empList;
    }

    //*************************************
    //UPDATE an customer's email address
    //*************************************
    public static void updateCustomer (String id, String name) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
/*
*     cust_id,
    name,
    gender,
    age,
    email,
    street,
    city,
    country,
    zip,
    house
    * */
        String updateStmt =
                "BEGIN\n" +
                        "UPDATE customers\n" +
                        "SET " +
//                        "   NAME = '" + name + "',\n" +
//                        "   LAST_NAME = '" + lastname + "',\n" +
//                        "   EMAIL = '" + email + "',\n" +
                        "   NAME = '" + name + "'\n" +
                        "WHERE CUST_ID = " + id + ";\n" +
                        "   COMMIT;\n" +
                        "END;";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    //*************************************
    //DELETE an customer
    //*************************************
    public static void deleteCustomer (String id) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM customers\n" +
                        "         WHERE cust_id ="+ id +";\n" +
                        "   COMMIT;\n" +
                        "END;";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    //*************************************
    //INSERT an customer
    //*************************************
    public static void insertCustomer(String id, String name) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO customers\n" +
                        "(CUST_ID, NAME)\n" +
                        "VALUES\n" +
                        "(" + id + ", '"+name+"');\n" +
                        "END;";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
}
