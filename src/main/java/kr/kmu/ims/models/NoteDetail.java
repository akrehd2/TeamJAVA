package kr.kmu.ims.models;

import javafx.beans.property.*;

import java.sql.Date;

/**
 * Created by ONUR BASKIRT on 27.02.2016.
 */
public class NoteDetail {
    //Declare Employees Table Columns
    public IntegerProperty GoodsAdjustmentNoteDetailId;
    public IntegerProperty GoodsAdjustmentNoteId;
    public IntegerProperty ItemId;
    public StringProperty ItemCode;
    public StringProperty ItemDescription;
    public DoubleProperty StockQty;
    public StringProperty Uom;
    public DoubleProperty AdjustmentQty;
    public StringProperty Location;
    public StringProperty AdjustmentReason;

    //Constructor
    public NoteDetail() {
        this.GoodsAdjustmentNoteDetailId =  new SimpleIntegerProperty();
        this.GoodsAdjustmentNoteId =  new SimpleIntegerProperty();
        this.ItemId =  new SimpleIntegerProperty();
        this.ItemCode = new SimpleStringProperty();
        this.ItemDescription = new SimpleStringProperty();
        this.StockQty =  new SimpleDoubleProperty();
        this.Uom = new SimpleStringProperty();
        this.AdjustmentQty =  new SimpleDoubleProperty();
        this.Location = new SimpleStringProperty();
        this.AdjustmentReason = new SimpleStringProperty();
    }






    public int get_Goods_adjustment_note_detail_id() {
        return GoodsAdjustmentNoteDetailId.get();
    }
    public void set_Goods_adjustment_note_detail_id(int value){
        this.GoodsAdjustmentNoteDetailId.set(value);
    }
    public IntegerProperty Goods_adjustment_note_detail_id_Property(){
        return GoodsAdjustmentNoteDetailId;
    }

    public int get_Goods_adjustment_note_id() {
        return GoodsAdjustmentNoteId.get();
    }
    public void set_Goods_adjustment_note_id(int value){
        this.GoodsAdjustmentNoteId.set(value);
    }
    public IntegerProperty Goods_adjustment_note_id_Property(){
        return GoodsAdjustmentNoteId;
    }

    public int get_Item_id() {
        return ItemId.get();
    }
    public void set_Item_id(int value){
        this.ItemId.set(value);
    }
    public IntegerProperty Item_id_Property(){
        return ItemId;
    }

    public String get_Item_code () {
        return ItemCode.get();
    }
    public void set_Item_code(String value){
        this.ItemCode.set(value);
    }
    public StringProperty Item_code_Property() {
        return ItemCode;
    }

    public String get_Item_description () {
        return ItemDescription.get();
    }
    public void set_Item_description(String value){
        this.ItemDescription.set(value);
    }
    public StringProperty Item_description_Property() {
        return ItemDescription;
    }

//----------------------------------------------------------------

    public double getStockQty() {
        return StockQty.get();
    }

    public void setStockQty(double commissionPct){
        this.StockQty.set(commissionPct);
    }

    public DoubleProperty stockQtyProperty(){
        return StockQty;
    }

    public String getUom(){
        return Uom.get();
    }
    public void setUom (String uom){
        this.Uom.set(uom);
    }

    public StringProperty UomProperty() {
        return Uom;
    }


    public double getAdjustmentQty() {
        return AdjustmentQty.get();
    }

    public void setAdjustmentQty(double adjustmentQty){
        this.AdjustmentQty.set(adjustmentQty);
    }

    public DoubleProperty adjustmentQtyProperty(){
        return AdjustmentQty;
    }


    public String getLocation() {
        return Location.get();
    }

    public void setLocation (String location){
        this.Location.set(location);
    }

    public StringProperty LocationProperty() {
        return Location;
    }


    public String getAdjustmentReason () {
        return AdjustmentReason.get();
    }

    public void setAdjustmentReason (String adjustmentreason){
        this.AdjustmentReason.set(adjustmentreason);
    }

    public StringProperty AdjustmentReasonProperty() {
        return AdjustmentReason;
    }






}
