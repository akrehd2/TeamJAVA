package models;

import javax.persistence.*;

@Entity
@Table(name = "GOODS_ADJUSTMENT_NOTE_DETAILS", schema = "C##IMS", catalog = "")
public class GoodsAdjustmentNoteDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "GOODS_ADJUSTMENT_NOTE_DETAIL_ID", nullable = false, precision = 0)
    private int goodsAdjustmentNoteDetailId;
    @Basic
    @Column(name = "GOODS_ADJUSTMENT_NOTE_ID", nullable = false, precision = 0)
    private int goodsAdjustmentNoteId;
    @Basic
    @Column(name = "ITEM_ID", nullable = false, precision = 0)
    private int itemId;
    @Basic
    @Column(name = "ITEM_CODE", nullable = false, length = 50)
    private String itemCode;
    @Basic
    @Column(name = "ITEM_DESCRIPTION", nullable = false, length = 255)
    private String itemDescription;
    @Basic
    @Column(name = "STOCK_QTY", nullable = false)
    private Object stockQty;
    @Basic
    @Column(name = "UOM", nullable = true, length = 50)
    private String uom;
    @Basic
    @Column(name = "ADJUSTMENT_QTY", nullable = false)
    private Object adjustmentQty;
    @Basic
    @Column(name = "LOCATION", nullable = true, length = 50)
    private String location;
    @Basic
    @Column(name = "ADJUSTMENT_REASON", nullable = true, length = 50)
    private String adjustmentReason;

    public int getGoodsAdjustmentNoteDetailId() {
        return goodsAdjustmentNoteDetailId;
    }

    public void setGoodsAdjustmentNoteDetailId(int goodsAdjustmentNoteDetailId) {
        this.goodsAdjustmentNoteDetailId = goodsAdjustmentNoteDetailId;
    }

    public int getGoodsAdjustmentNoteId() {
        return goodsAdjustmentNoteId;
    }

    public void setGoodsAdjustmentNoteId(int goodsAdjustmentNoteId) {
        this.goodsAdjustmentNoteId = goodsAdjustmentNoteId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Object getStockQty() {
        return stockQty;
    }

    public void setStockQty(Object stockQty) {
        this.stockQty = stockQty;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Object getAdjustmentQty() {
        return adjustmentQty;
    }

    public void setAdjustmentQty(Object adjustmentQty) {
        this.adjustmentQty = adjustmentQty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAdjustmentReason() {
        return adjustmentReason;
    }

    public void setAdjustmentReason(String adjustmentReason) {
        this.adjustmentReason = adjustmentReason;
    }
}
