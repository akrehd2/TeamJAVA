package kr.kmu.ims.repositories;

import kr.kmu.ims.models.Department;
import kr.kmu.ims.models.WorkCenter;
import kr.kmu.ims.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRepository {

    public static String searchDepartment (String Name) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_NAME = '"+Name +"'";


        //Execute SELECT statement
        try {

            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            Department department = getDepartmentFromResultSet(rsEmp);

            //Send ResultSet to the getCustomerList method and get customer object
            String departmentID_String = String.valueOf(department.getDEPARTMENT_ID());
            System.out.println(departmentID_String);


            //Return customer object
            return departmentID_String;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }
    private static Department getDepartmentFromResultSet(ResultSet rs) throws SQLException
    {
        Department emp = null;
        if (rs.next()) {
            emp = new Department();
            emp.setDEPARTMENT_ID(rs.getInt("DEPARTMENT_ID"));
            emp.setDEPARTMENT_NAME(rs.getString("DEPARTMENT_NAME"));
        }
        return emp;
    }
    //=--------------------------------------------------------------------------------------------------------
    //insert
    public static void insertDepartment ( String Name) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO DEPARTMENTS\n" +
                        "( DEPARTMENT_NAME," +
                        "    location,\n" +
                        "    phone_ext,\n" +
                        "    head_of_department_id,\n" +
                        "    sort_order,\n" +
                        "    created_by,\n" +
                        "    created_on,\n" +
                        "    last_updated_by,\n" +
                        "    last_updated_on\n" +
                        ")\n" +
                        "VALUES\n" +
                        "('"+Name+"',\n" +
                        "null,\n" +
                        "null,\n" +
                        "null,\n" +
                        "null,\n" +
                        "null,\n" +
                        "null,\n" +
                        "null,\n" +
                        "null);\n" +
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
    public static void deleteDepartment (String ID, String Name) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt ="BEGIN\n" +
                "DELETE FROM DEPARTMENTS\n" +
                "WHERE DEPARTMENT_ID = "+ ID +"\n" +
                "and DEPARTMENT_NAME = '"+Name+"';\n" +
                "COMMIT; \n" +
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
