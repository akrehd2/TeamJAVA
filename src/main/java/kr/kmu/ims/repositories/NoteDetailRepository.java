package kr.kmu.ims.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kr.kmu.ims.models.Customer;
import kr.kmu.ims.models.Goods;
import kr.kmu.ims.models.NoteDetail;
import kr.kmu.ims.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteDetailRepository {

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

}
