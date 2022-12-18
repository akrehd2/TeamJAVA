package kr.kmu.ims.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kr.kmu.ims.models.Customer;
import kr.kmu.ims.models.Goods;
import kr.kmu.ims.models.NoteDetail;
import kr.kmu.ims.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteDetailRepository {

    //*******************************
    //SELECT a Customer
    //*******************************
    //*******************************
    public static Customer searchCustomer (String id) throws SQLException, ClassNotFoundException {
    public static ObservableList<NoteDetail> searchNote () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM GOODS_ADJUSTMENT_NOTE_DETAILS";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getCustomerList method and get customer object

            ObservableList<NoteDetail> list = getNoteDetaillist(rs);
            System.out.println(list.get(0).get_Goods_adjustment_note_detail_id());

            //Return customer object
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from customers operation

    private static ObservableList<NoteDetail> getNoteDetaillist(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Customer objects
        ObservableList<NoteDetail> ganList = FXCollections.observableArrayList();

        while (rs.next()) {
            NoteDetail gan = new NoteDetail();
            gan.set_Goods_adjustment_note_detail_id(rs.getInt("GOODS_ADJUSTMENT_NOTE_DETAIL_ID"));
            gan.set_Goods_adjustment_note_id(rs.getInt("GOODS_ADJUSTMENT_NOTE_ID"));
            gan.set_Item_id(rs.getInt("ITEM_ID"));
            gan.set_Item_code(rs.getString("ITEM_CODE"));
            gan.set_Item_description(rs.getString("ITEM_DESCRIPTION"));
            gan.setStockQty(rs.getDouble("STOCK_QTY"));
            gan.setUom(rs.getString("UOM"));
            gan.setAdjustmentQty(rs.getDouble("ADJUSTMENT_QTY"));
            gan.setLocation(rs.getString("LOCATION"));
            gan.setAdjustmentReason(rs.getString("ADJUSTMENT_REASON"));

            ganList.add(gan);
        }
        //return empList (ObservableList of Customers)
        return ganList;
    }

    //*************************************
    //UPDATE an customer's email address
    //*************************************
    public static void updateCustomer (String id, String name) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement

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
            System.out.print("Okay");
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }



    //--------------------------------------------------------------------------
    //finalize

    public static void FinalizeUpdateDB(String id) throws SQLException, ClassNotFoundException {

        Date from = new Date();
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = transFormat.format(from);

        String updateStmt ="BEGIN\n" +
                "\nUPDATE GOODS_ADJUSTMENT_NOTES\n" +
                "SET\n" +
                "STATUS = 'finalized',\n" +
                "STATUS_DATE = (to_timestamp( '" +format+"')) , \n" +
                "Is_Finalized= '1' \n" +
                "WHERE GOODS_ADJUSTMENT_NOTE_ID = '"+ id +"'; \n"+
                "END;";
        //Execute UPDATE operation


        try {
            System.out.print(updateStmt);
            DBUtil.dbExecuteUpdate(updateStmt);


        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
}
