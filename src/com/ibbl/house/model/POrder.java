package com.ibbl.house.model;

import com.ibbl.common.model.GenericModel;
import com.ibbl.security.model.User;
import org.springframework.validation.BindingResult;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Copyright &copy; 2002-2003 Islami Bank Bangladesh Limited
 * <p>
 * Original author: Khomeni
 * Date: 21/08/2017 10:50 AM
 * Last modification by: Khomeni: Khomeni
 * Last modification on 21/08/2017: 21/08/2017 10:50 AM
 * Current revision: 1.0.0: 1.1 $
 * <p>
 * Revision History:
 * ------------------
 */

@Entity
@Table(name = "T23_PURCHASE_ORDER")
public class POrder extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 2, max = 10, message = "Min 2, Max 10 Digit allowed.")
    @Column(name = "order_no")
    private String orderNo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model")
    private MModel mModel;

    @NotNull(message = "Quantity is Required")
    @Min(value = 100, message = "Minimum Quantity is 100")
    private Integer qty;


    @NotNull(message = "Order date is required.")
    @Temporal(TemporalType.DATE)
    @Column(name = "order_dt")
    private Date orderDate;

    @NotNull(message = "Scheduled Shipping date is required.")
    @Temporal(TemporalType.DATE)
    @Column(name = "sch_ship_dt")
    private Date scheduledShippingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "inspect_date")
    private Date inspectionDate;


    @Temporal(TemporalType.DATE)
    @Column(name = "exp_ship_dt")
    private Date expectedShippingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "shipped_on")
    private Date shippedOn;

    @NotNull(message = "Data Operator is required.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OP_ID")
    private User operator;

    @NotNull(message = "Record date is required.")
    @Temporal(TemporalType.DATE)
    @Column(name = "rec_dt")
    private Date recordDate;

    @Override
    public void validate(BindingResult result) {
        if (qty == null || qty < 100) {
            result.rejectValue("qty", "", "Minimum Quantity is 100");
        }
        if (mModel == null) {
            result.rejectValue("mModel.id", "", "Please Select A Model");
        }
    }

    @Override
    public String info() {
        return orderNo + ", " + qty + " PCS";
    }

    // =======================================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public MModel getmModel() {
        return mModel;
    }

    public void setmModel(MModel mModel) {
        this.mModel = mModel;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public User getOperator() {
        return operator;
    }

    public void setOperator(User operator) {
        this.operator = operator;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public Date getScheduledShippingDate() {
        return scheduledShippingDate;
    }

    public void setScheduledShippingDate(Date scheduledShippingDate) {
        this.scheduledShippingDate = scheduledShippingDate;
    }

    public Date getExpectedShippingDate() {
        return expectedShippingDate;
    }

    public void setExpectedShippingDate(Date expectedShippingDate) {
        this.expectedShippingDate = expectedShippingDate;
    }

    public Date getShippedOn() {
        return shippedOn;
    }

    public void setShippedOn(Date shippedOn) {
        this.shippedOn = shippedOn;
    }
}
