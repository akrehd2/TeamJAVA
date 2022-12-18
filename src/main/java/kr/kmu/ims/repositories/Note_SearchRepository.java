package kr.kmu.ims.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import kr.kmu.ims.models.Customer;
import kr.kmu.ims.models.Goods;
import kr.kmu.ims.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Note_SearchRepository {

    //*******************************
    //SELECT Customers
    //*******************************
    public static ObservableList<Goods> searchGoods () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM GOODS_ADJUSTMENT_NOTES";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getCustomerList method and get customer object

            ObservableList<Goods> list = getGoodslist(rs);
            System.out.println(list.get(0).getGoodsAdjustmentNoteId());


            //Return customer object
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from customers operation

    private static ObservableList<Goods> getGoodslist(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Customer objects
        ObservableList<Goods> ganList = FXCollections.observableArrayList();

        while (rs.next()) {
            Goods gan = new Goods();
            gan.setGoodsAdjustmentNoteId(rs.getInt("GOODS_ADJUSTMENT_NOTE_ID"));
            gan.setDocument_no(rs.getString("DOCUMENT_NO"));
            gan.setAdjustment_Date(rs.getDate("ADJUSTMENT_DATE"));
            gan.setTrans_type(rs.getString("TRANS_TYPE"));
            gan.setAdjustment_mode(rs.getString("ADJUSTMENT_MODE"));
            gan.setAdjustment_reason(rs.getString("ADJUSTMENT_REASON"));
            gan.setStoreid(rs.getInt("STOREID"));
            gan.setRemarks(rs.getString("REMARKS"));
            gan.setCreated_by(rs.getInt("created_by"));
            gan.setCreated_on(rs.getDate("created_on"));
            gan.setLast_updated_by(rs.getInt("last_updated_by"));
            gan.setLast_updated_on(rs.getDate("last_updated_on"));
            gan.setStatus(rs.getString("status"));
            gan.setStatus_date(rs.getDate("STATUS_DATE"));
            gan.setIs_finalized(rs.getInt("IS_FINALIZED"));
            gan.setFinalized_by(rs.getInt("FINALIZED_BY"));
            gan.setFinalized_on(rs.getDate("FINALIZED_ON"));

            ganList.add(gan);
        }
        //return empList (ObservableList of Customers)
        return ganList;
    }





}
