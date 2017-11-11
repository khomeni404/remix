package com.ibbl.house.model;

import com.ibbl.common.model.GenericModel;
import com.ibbl.security.model.User;
import org.springframework.validation.BindingResult;

import javax.persistence.*;
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
@Table(name = "T23_SAMPLE_PP")
public class SamplePP extends GenericModel {
    @Override
    public void validate(BindingResult result) {

    }

    @Override
    public String info() {
        return null;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OP_ID")
    private User operator;

    @Temporal(TemporalType.DATE)
    @Column(name = "rec_dt")
    private Date recordDate;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SAMPLE")
    private MModel mModel;

    // ================================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MModel getmModel() {
        return mModel;
    }

    public void setmModel(MModel mModel) {
        this.mModel = mModel;
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
}
