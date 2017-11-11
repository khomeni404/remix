package com.ibbl.common.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.io.Serializable;

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

public abstract class GenericModel implements Serializable {

    /**
     * Set Validation Error to the BindingResult
     *
     * @param result BindingResult
     */
    public abstract void validate(BindingResult result);

    /**
     * Method returns basic information of Object holds.
     *
     * @return String
     */
    public abstract String info();

    @Override
    public String toString() {
        return info();
    }
}
