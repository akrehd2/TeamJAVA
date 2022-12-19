package kr.kmu.ims.models;

import javafx.beans.property.*;
import javafx.scene.control.Button;

import java.sql.Date;
import java.sql.Timestamp;
public class Department {
    //Declare Employees Table Columns
    private IntegerProperty DEPARTMENT_ID;
    private StringProperty DEPARTMENT_NAME;


    //Constructor
    public Department() {
        this.DEPARTMENT_ID = new SimpleIntegerProperty();
        this.DEPARTMENT_NAME = new SimpleStringProperty();

    }

    //goods_adjustment_note_id
    public int getDEPARTMENT_ID() {
        return DEPARTMENT_ID.get();
    }

    public void setDEPARTMENT_ID(int id) {
        this.DEPARTMENT_ID.set(id);
    }

    public IntegerProperty DEPARTMENT_IDProperty() {
        return DEPARTMENT_ID;
    }

    //document_no
    public String getDEPARTMENT_NAME() {
        return DEPARTMENT_NAME.get();
    }

    public void setDEPARTMENT_NAME(String name) {
        this.DEPARTMENT_NAME.set(name);
    }

    public StringProperty DEPARTMENT_NAMEProperty() {
        return DEPARTMENT_NAME;
    }



}
