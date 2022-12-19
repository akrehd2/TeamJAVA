package kr.kmu.ims.repositories;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.kmu.ims.models.Employee;
import kr.kmu.ims.models.Goods;
import kr.kmu.ims.models.WorkCenter;
import kr.kmu.ims.util.DBUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkCenterRepository {

//------------------------------------------------------------------------------------------------------------
    public static String searchWorkCenter (String Name) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM WORK_CENTERS WHERE WORK_CENTER_NAME = '"+Name +"'";


        //Execute SELECT statement
        try {

            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            WorkCenter workCenter = getWorkCenterFromResultSet(rsEmp);

            //Send ResultSet to the getCustomerList method and get customer object
            String workCenterID_String = String.valueOf(workCenter.getWORK_CENTER_ID());
            System.out.println(workCenterID_String);


            //Return customer object
            return workCenterID_String;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }
    private static WorkCenter getWorkCenterFromResultSet(ResultSet rs) throws SQLException
    {
        WorkCenter emp = null;
        if (rs.next()) {
            emp = new WorkCenter();
            emp.setWORK_CENTER_ID(rs.getInt("WORK_CENTER_ID"));
            emp.setWORK_CENTER_NAME(rs.getString("WORK_CENTER_NAME"));
        }
        return emp;
    }
    //=--------------------------------------------------------------------------------------------------------
    //insert
    public static void insertWorkCenter ( String Name) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO WORK_CENTERS\n" +
                        "( WORK_CENTER_NAME)\n" +
                        "VALUES\n" +
                        "('"+Name+"');\n" +
                        "END;";

        //Execute DELETE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
    //-------------------------------------------------------------------------------------------------------------
    // delete
    public static void deleteWorkCenter (String ID, String Name) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "DELETE FROM WORK_CENTERS\n" +
                        "WHERE WORK_CENTER_ID = " + ID +
                        " and "+" WORK_CENTER_NAME = '"+Name+"';\n" +
                        "COMMIT;\n" +
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
