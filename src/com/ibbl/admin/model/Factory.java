package com.ibbl.admin.model;

import com.ibbl.mix.model.Trim;
import com.ibbl.security.model.User;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.validation.BindingResult;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@Table(name = "T23_BUYER")
public class Factory extends User {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "destination")
    @Fetch(value = FetchMode.SELECT)
    private List<Trim> trimList = new ArrayList<>(0);

    @NotNull(message = "Name sign is Required")
    @Size(min = 2, max = 4, message = "Name sign must be within 2-4 character.")
    @Column(length = 4)
    private String nameSign;

    @Size(max = 100)
    @Column(length = 100)
    private String address;

    @Size(max = 20)
    @Column(length = 20)
    private String cell;

    @Size(max = 20)
    @Column(length = 20)
    private String tel;


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
        return null;
    }

    // ===============================================


    public String getNameSign() {
        return nameSign;
    }

    public void setNameSign(String nameSign) {
        this.nameSign = nameSign;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCell() {
        return cell;
    }

    /**
     *
     * @param cell
     */
    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
