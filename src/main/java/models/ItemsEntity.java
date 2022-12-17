package models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ITEMS", schema = "C##IMS", catalog = "")
public class ItemsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ITEM_ID", nullable = false, precision = 0)
    private int itemId;
    @Basic
    @Column(name = "ITEM_CODE", nullable = false, length = 50)
    private String itemCode;
    @Basic
    @Column(name = "ITEM_NAME", nullable = false, length = 100)
    private String itemName;
    @Basic
    @Column(name = "PURCHASE_DESCRIPTION", nullable = true, length = 100)
    private String purchaseDescription;
    @Basic
    @Column(name = "IS_PRINT_BARCODE", nullable = true, length = 1)
    private String isPrintBarcode;
    @Basic
    @Column(name = "DEPARTMENT_ID", nullable = true, precision = 0)
    private Integer departmentId;
    @Basic
    @Column(name = "CATEGORY_ID", nullable = true, precision = 0)
    private Integer categoryId;
    @Basic
    @Column(name = "BRAND_ID", nullable = true, precision = 0)
    private Integer brandId;
    @Basic
    @Column(name = "ITEM_TYPE_ID", nullable = true, length = 50)
    private String itemTypeId;
    @Basic
    @Column(name = "ITEM_CLASS_ID", nullable = true, length = 50)
    private String itemClassId;
    @Basic
    @Column(name = "ITEM_LOCATION", nullable = true, length = 50)
    private String itemLocation;
    @Basic
    @Column(name = "STORE_ID", nullable = true, precision = 0)
    private Integer storeId;
    @Basic
    @Column(name = "ARTICLE", nullable = true, length = 50)
    private String article;
    @Basic
    @Column(name = "STOCK_QTY", nullable = false)
    private Object stockQty;
    @Basic
    @Column(name = "IS_TRACK_INVENTORY", nullable = true, length = 1)
    private String isTrackInventory;
    @Basic
    @Column(name = "UOM", nullable = true, length = 50)
    private String uom;
    @Basic
    @Column(name = "LOW_STOCK_QTY", nullable = true)
    private Object lowStockQty;
    @Basic
    @Column(name = "MIN_ORDER_QTY", nullable = true)
    private Object minOrderQty;
    @Basic
    @Column(name = "MAX_ORDER_QTY", nullable = true)
    private Object maxOrderQty;
    @Basic
    @Column(name = "LEAD_TIME_DAYS", nullable = true)
    private Object leadTimeDays;
    @Basic
    @Column(name = "SUPPLIER_ID", nullable = true, precision = 0)
    private Integer supplierId;
    @Basic
    @Column(name = "ITEM_ORIGIN", nullable = true, length = 50)
    private String itemOrigin;
    @Basic
    @Column(name = "OPENING_BALANCE", nullable = true)
    private Object openingBalance;
    @Basic
    @Column(name = "IS_ACTIVE", nullable = true, length = 1)
    private String isActive;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPurchaseDescription() {
        return purchaseDescription;
    }

    public void setPurchaseDescription(String purchaseDescription) {
        this.purchaseDescription = purchaseDescription;
    }

    public String getIsPrintBarcode() {
        return isPrintBarcode;
    }

    public void setIsPrintBarcode(String isPrintBarcode) {
        this.isPrintBarcode = isPrintBarcode;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(String itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getItemClassId() {
        return itemClassId;
    }

    public void setItemClassId(String itemClassId) {
        this.itemClassId = itemClassId;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Object getStockQty() {
        return stockQty;
    }

    public void setStockQty(Object stockQty) {
        this.stockQty = stockQty;
    }

    public String getIsTrackInventory() {
        return isTrackInventory;
    }

    public void setIsTrackInventory(String isTrackInventory) {
        this.isTrackInventory = isTrackInventory;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Object getLowStockQty() {
        return lowStockQty;
    }

    public void setLowStockQty(Object lowStockQty) {
        this.lowStockQty = lowStockQty;
    }

    public Object getMinOrderQty() {
        return minOrderQty;
    }

    public void setMinOrderQty(Object minOrderQty) {
        this.minOrderQty = minOrderQty;
    }

    public Object getMaxOrderQty() {
        return maxOrderQty;
    }

    public void setMaxOrderQty(Object maxOrderQty) {
        this.maxOrderQty = maxOrderQty;
    }

    public Object getLeadTimeDays() {
        return leadTimeDays;
    }

    public void setLeadTimeDays(Object leadTimeDays) {
        this.leadTimeDays = leadTimeDays;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getItemOrigin() {
        return itemOrigin;
    }

    public void setItemOrigin(String itemOrigin) {
        this.itemOrigin = itemOrigin;
    }

    public Object getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Object openingBalance) {
        this.openingBalance = openingBalance;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
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
}
