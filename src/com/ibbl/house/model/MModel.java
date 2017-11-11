package com.ibbl.house.model;

import com.ibbl.admin.model.Supplier;
import com.ibbl.common.model.GenericModel;
import com.ibbl.security.model.User;
import org.apache.commons.validator.GenericValidator;
import org.springframework.validation.BindingResult;

import javax.persistence.*;
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
@Table(name = "T23_MODEL_MASTER")
public class MModel extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model_no")
    private String modelNo;

    @NotNull(message = "MModel Name is Required")
    @Size(min = 3, max = 100, message = "Length must between 3 - 100 Character")
    @Column(name = "model_name", length = 100)
    private String modelName;

    @NotNull(message = "Please Select a Supplier")
    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier;

    @NotNull(message = "Request Date is required.")
    @Temporal(TemporalType.DATE)
    @Column(name = "req_dt")
    private Date requestDate = new Date();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "mModel")
    private SampleA sampleA;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "mModel")
    private SampleB sampleB;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "mModel")
    private SamplePP samplePP;

    @NotNull
    private Integer status;

    @Column(name = "exp_qty")
    private Integer expectedQty;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OP_ID")
    private User operator;

    @Temporal(TemporalType.DATE)
    @Column(name = "rec_dt")
    private Date recordDate;

    @Override
    public void validate(BindingResult result) {

    }

    @Override
    public String info() {
        return GenericValidator.isBlankOrNull(modelNo) ? modelName : modelNo + "/" + modelName;
    }


    // ================================================


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getExpectedQty() {
        return expectedQty;
    }

    public void setExpectedQty(Integer expectedQty) {
        this.expectedQty = expectedQty;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public SampleA getSampleA() {
        return sampleA;
    }

    public void setSampleA(SampleA sampleA) {
        this.sampleA = sampleA;
    }

    public SampleB getSampleB() {
        return sampleB;
    }

    public void setSampleB(SampleB sampleB) {
        this.sampleB = sampleB;
    }

    public SamplePP getSamplePP() {
        return samplePP;
    }

    public void setSamplePP(SamplePP samplePP) {
        this.samplePP = samplePP;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
}
