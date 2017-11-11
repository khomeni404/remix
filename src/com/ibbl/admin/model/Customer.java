package com.ibbl.admin.model;

import com.ibbl.common.model.GenericModel;
import com.ibbl.security.model.User;
import org.springframework.validation.BindingResult;

import javax.persistence.*;
import java.util.Date;

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
@Table(name = "T23_CUSTOMER")
public class Customer extends User {
    @Override
    public void validate(BindingResult result) {

    }

    @Override
    public String info() {
        return null;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OP_ID")
    private User operator;

    @Temporal(TemporalType.DATE)
    @Column(name = "rec_dt")
    private Date recordDate;
}
