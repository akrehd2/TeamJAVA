package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "GOODS_ADJUSTMENT_NOTES", schema = "C##IMS", catalog = "")
public class GoodsAdjustmentNotesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "GOODS_ADJUSTMENT_NOTE_ID", nullable = false, precision = 0)
    private int goodsAdjustmentNoteId;
    @Basic
    @Column(name = "DOCUMENT_NO", nullable = true, length = 50)
    private String documentNo;
    @Basic
    @Column(name = "ADJUSTMENT_DATE", nullable = true)
    private Timestamp adjustmentDate;
    @Basic
    @Column(name = "TRANS_TYPE", nullable = true, length = 50)
    private String transType;
    @Basic
    @Column(name = "ADJUSTMENT_MODE", nullable = true, length = 50)
    private String adjustmentMode;
    @Basic
    @Column(name = "ADJUSTMENT_REASON", nullable = true, length = 50)
    private String adjustmentReason;
    @Basic
    @Column(name = "STOREID", nullable = true, precision = 0)
    private Integer storeid;
    @Basic
    @Column(name = "REMARKS", nullable = true, length = 1000)
    private String remarks;
    @Basic
    @Column(name = "CREATED_BY", nullable = true, precision = 0)
    private Integer createdBy;
    @Basic
    @Column(name = "CREATED_ON", nullable = true)
    private Timestamp createdOn;
    @Basic
    @Column(name = "LAST_UPDATED_BY", nullable = true, precision = 0)
    private Integer lastUpdatedBy;
    @Basic
    @Column(name = "LAST_UPDATED_ON", nullable = true)
    private Timestamp lastUpdatedOn;
    @Basic
    @Column(name = "STATUS", nullable = true, length = 50)
    private String status;
    @Basic
    @Column(name = "STATUS_DATE", nullable = true)
    private Timestamp statusDate;
    @Basic
    @Column(name = "IS_FINALIZED", nullable = true, precision = 0)
    private Boolean isFinalized;
    @Basic
    @Column(name = "FINALIZED_BY", nullable = true, precision = 0)
    private Integer finalizedBy;
    @Basic
    @Column(name = "FINALIZED_ON", nullable = true)
    private Timestamp finalizedOn;

    public int getGoodsAdjustmentNoteId() {
        return goodsAdjustmentNoteId;
    }

    public void setGoodsAdjustmentNoteId(int goodsAdjustmentNoteId) {
        this.goodsAdjustmentNoteId = goodsAdjustmentNoteId;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public Timestamp getAdjustmentDate() {
        return adjustmentDate;
    }

    public void setAdjustmentDate(Timestamp adjustmentDate) {
        this.adjustmentDate = adjustmentDate;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getAdjustmentMode() {
        return adjustmentMode;
    }

    public void setAdjustmentMode(String adjustmentMode) {
        this.adjustmentMode = adjustmentMode;
    }

    public String getAdjustmentReason() {
        return adjustmentReason;
    }

    public void setAdjustmentReason(String adjustmentReason) {
        this.adjustmentReason = adjustmentReason;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Timestamp getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Timestamp statusDate) {
        this.statusDate = statusDate;
    }

    public Boolean getFinalized() {
        return isFinalized;
    }

    public void setFinalized(Boolean finalized) {
        isFinalized = finalized;
    }

    public Integer getFinalizedBy() {
        return finalizedBy;
    }

    public void setFinalizedBy(Integer finalizedBy) {
        this.finalizedBy = finalizedBy;
    }

    public Timestamp getFinalizedOn() {
        return finalizedOn;
    }

    public void setFinalizedOn(Timestamp finalizedOn) {
        this.finalizedOn = finalizedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsAdjustmentNotesEntity that = (GoodsAdjustmentNotesEntity) o;
        return Objects.equals(isFinalized, that.isFinalized);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isFinalized);
    }
}
