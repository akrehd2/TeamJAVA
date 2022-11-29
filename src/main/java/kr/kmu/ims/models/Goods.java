package kr.kmu.ims.models;

import javafx.beans.property.*;

import java.sql.Date;

/**
 * Created by ONUR BASKIRT on 27.02.2016.
 */
public class Goods {
    //Declare Employees Table Columns
    private IntegerProperty goods_adjustment_note_id;
    private StringProperty document_no;
    private SimpleObjectProperty<Date> adjustment_date;
    private StringProperty trans_type;
    private StringProperty adjustment_mode;
    private StringProperty adjustment_reason;
    private IntegerProperty storeid;
    private StringProperty  remarks;
    private IntegerProperty created_by;
    private SimpleObjectProperty<Date> created_on;
    private IntegerProperty last_updated_by;
    private SimpleObjectProperty<Date> last_updated_on;
    private StringProperty status;
    private SimpleObjectProperty<Date> status_date;
    private IntegerProperty is_finalized;
    private IntegerProperty finalized_by;
    private SimpleObjectProperty<Date> finalized_on;

    //Constructor
    public Goods() {
        this.goods_adjustment_note_id = new SimpleIntegerProperty();
        this.document_no = new SimpleStringProperty();
        this.adjustment_date = new SimpleObjectProperty<>();
        this.trans_type = new SimpleStringProperty();
        this.adjustment_mode = new SimpleStringProperty();
        this.adjustment_reason = new SimpleStringProperty();
        this.storeid = new SimpleIntegerProperty();
        this.remarks = new SimpleStringProperty();
        this.created_by = new SimpleIntegerProperty();
        this.created_on = new SimpleObjectProperty<>();
        this.last_updated_by = new SimpleIntegerProperty();
        this.last_updated_on = new SimpleObjectProperty<>();
        this.status = new SimpleStringProperty();
        this.status_date = new SimpleObjectProperty<>();
        this.is_finalized = new SimpleIntegerProperty();
        this.finalized_by = new SimpleIntegerProperty();
        this.finalized_on = new SimpleObjectProperty<>();
    }

    //goods_adjustment_note_id
    public int getGoodsAdjustmentNoteId() {
        return goods_adjustment_note_id.get();
    }

    public void setGoodsAdjustmentNoteId(int goods_adjustment_note_id){this.goods_adjustment_note_id.set(goods_adjustment_note_id);}

    public IntegerProperty goodsAdjustmentNoteIdProperty(){
        return goods_adjustment_note_id;
    }

    //document_no
    public String getDocument_no () {
        return document_no.get();
    }

    public void setDocument_no(String document_no){
        this.document_no.set(document_no);
    }

    public StringProperty documentNoProperty() {
        return document_no;
    }

    //adjustment_date
    public Object getAdjustment_date(){
        return adjustment_date.get();
    }

    public void setHireDate(Date adjustmentdate){
        this.adjustment_date.set(adjustmentdate);
    }

    public SimpleObjectProperty<Date> adjustmentDateProperty(){
        return adjustment_date;
    }


    //trans_type
    public String getTrans_type () {return trans_type.get();}

    public void setTrans_type (String trans_type){this.trans_type.set(trans_type);}

    public StringProperty transTypeProperty() {return trans_type;}

    //adjustment_mode
    public String getAdjustment_mode () {return adjustment_mode.get();}

    public void setAdjustment_mode (String adjustmentMode){this.adjustment_mode.set(adjustmentMode);}

    public StringProperty adjustmentModeProperty() {
        return adjustment_mode;
    }

    //adjustment_reason
    public String getAdjustment_reason () {
        return adjustment_reason.get();
    }

    public void setJobId (String adjustmentReason){this.adjustment_reason.set(adjustmentReason);}

    public StringProperty adjustmentReasonProperty() {
        return adjustment_reason;
    }


    //storeid
    public int getStoreid() {
        return storeid.get();
    }

    public void setStoreid(int storeId){this.storeid.set(storeId);}

    public IntegerProperty storeidProperty(){
        return storeid;
    }

    //remarks
    public String getRemarks () {return remarks.get();}

    public void setRemarks (String remarks){this.remarks.set(remarks);}

    public StringProperty remarksProperty() {return remarks;}


    //created_by
    public int getCreated_by() {return created_by.get();}

    public void setCreated_by(int created_by){this.created_by.set(created_by);}

    public IntegerProperty created_by_Property(){return created_by;}



    //created_on
    public Object getCreated_on(){
        return created_on.get();
    }

    public void setCreated_on(Date created_on){
        this.created_on.set(created_on);
    }

    public SimpleObjectProperty<Date> Created_on_Property(){
        return created_on;
    }

    //last_updated_by
    public int getLast_updated_by() {
        return last_updated_by.get();
    }

    public void setLast_updated_by(int last_updated_by){
        this.last_updated_by.set(last_updated_by);
    }

    public IntegerProperty last_updated_by_Property(){
        return last_updated_by;
    }


    //last_updated_on
    public Object getLast_updated_on(){
        return last_updated_on.get();
    }

    public void setLast_updated_on(Date last_updated_on){
        this.last_updated_on.set(last_updated_on);
    }

    public SimpleObjectProperty<Date> last_updated_on_Property(){
        return last_updated_on;
    }


    //status
    public String getStatus () {
        return status.get();
    }

    public void setStatus (String status){
        this.status.set(status);
    }

    public StringProperty status_Property() {
        return status;
    }


    //status_date
    public Object getStatus_date(){
        return status_date.get();
    }

    public void setStatus_date(Date status_date){
        this.status_date.set(status_date);
    }

    public SimpleObjectProperty<Date> status_date_Property(){
        return status_date;
    }


    //is_finalized
    public int getIs_finalized() {
        return is_finalized.get();
    }

    public void setIs_finalized(int is_finalized){
        this.is_finalized.set(is_finalized);
    }

    public IntegerProperty Is_finalized_Property(){
        return is_finalized;
    }



    //finalized_by
    public int getFinalized_by() {
        return finalized_by.get();
    }

    public void setFinalized_by(int finalized_by){
        this.finalized_by.set(finalized_by);
    }

    public IntegerProperty finalized_by_Property(){
        return finalized_by;
    }



    //finalized_on
    public Object getFinalized_on(){
        return finalized_on.get();
    }

    public void setFinalized_on(Date finalized_on){
        this.finalized_on.set(finalized_on);
    }

    public SimpleObjectProperty<Date> finalized_on_Property(){
        return finalized_on;
    }

}
