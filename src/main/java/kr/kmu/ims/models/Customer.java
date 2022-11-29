package kr.kmu.ims.models;

import javafx.beans.property.*;

import java.sql.Date;


public class Customer {
    //Declare Employees Table Columns
    private IntegerProperty customer_id;
    private StringProperty customer_name;
    private StringProperty  gender;
    private StringProperty  age;
    private StringProperty  email;
    private StringProperty  street;
    private StringProperty  city;
    private StringProperty  country;
    private StringProperty  zip;
    private StringProperty  house;

    //Constructor
    public Customer() {
        this.customer_id = new SimpleIntegerProperty();
        this.customer_name = new SimpleStringProperty();
        this.gender    = new SimpleStringProperty();
        this.age       = new SimpleStringProperty();
        this.email     = new SimpleStringProperty();
        this.street    = new SimpleStringProperty();
        this.city      = new SimpleStringProperty();
        this.country   = new SimpleStringProperty();
        this.zip       = new SimpleStringProperty();
        this.house      = new SimpleStringProperty();
    }

    //customer_id
    public int getCustomerId() {
        return customer_id.get();
    }

    public void setCustomerId(int employeeId){
        this.customer_id.set(employeeId);
    }

    public IntegerProperty customerIdProperty(){
        return customer_id;
    }

    //customer_name
    public String getName () {
        return customer_name.get();
    }

    public void setName(String value){
        this.customer_name.set(value);
    }

    public StringProperty nameProperty() {
        return customer_name;
    }

}
