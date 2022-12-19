package kr.kmu.ims.models;

import javafx.beans.property.*;
import javafx.scene.control.Button;

import java.sql.Date;
import java.sql.Timestamp;
public class WorkCenter {
    //Declare Employees Table Columns
    private IntegerProperty WORK_CENTER_ID;
    private StringProperty WORK_CENTER_NAME;


    //Constructor
    public WorkCenter() {
        this.WORK_CENTER_ID = new SimpleIntegerProperty();
        this.WORK_CENTER_NAME = new SimpleStringProperty();

    }

    //goods_adjustment_note_id
    public int getWORK_CENTER_ID() {
        return WORK_CENTER_ID.get();
    }

    public void setWORK_CENTER_ID(int id) {
        this.WORK_CENTER_ID.set(id);
    }

    public IntegerProperty WORK_CENTER_IDProperty() {
        return WORK_CENTER_ID;
    }

    //document_no
    public String getWORK_CENTER_NAME() {
        return WORK_CENTER_NAME.get();
    }

    public void setWORK_CENTER_NAME(String name) {
        this.WORK_CENTER_NAME.set(name);
    }

    public StringProperty WORK_CENTER_NAMEProperty() {
        return WORK_CENTER_NAME;
    }



}
