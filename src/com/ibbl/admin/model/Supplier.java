package com.ibbl.admin.model;

import com.ibbl.common.model.GenericModel;
import com.ibbl.mix.model.POSheet;
import com.ibbl.mix.model.Trim;
import com.ibbl.security.model.User;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.validation.BindingResult;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright &copy; 2002-2003 Islami Bank Bangladesh Limited
 * <p>
 * Original author: Khomeni
 * Date: 21/08/2017 12:34 PM
 * Last modification by: Khomeni: Khomeni
 * Last modification on 21/08/2017: 21/08/2017 12:34 PM
 * Current revision: 1.0.0: 1.1 $
 * <p>
 * Revision History:
 * ------------------
 */

@Entity
@Table(name = "T23_SUPPLIER")
public class Supplier extends User {


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "source")
    @Fetch(value = FetchMode.SELECT)
    private List<Trim> trimList = new ArrayList<>(0);

    @Override
    public void validate(BindingResult result) {

    }

    @Override
    public String info() {
        return getName();
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OP_ID")
    private User operator;

    @Temporal(TemporalType.DATE)
    @Column(name = "rec_dt")
    private Date recordDate;

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
