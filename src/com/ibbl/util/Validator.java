package com.ibbl.util;

import org.springframework.validation.Errors;

/**
 * Copyright &copy; 2002-2003 Islami Bank Bangladesh Limited
 * <p>
 * Original author: Khomeni
 * Date: 16/08/2017 10:25 AM
 * Last modification by: Khomeni: Khomeni
 * Last modification on 16/08/2017: 16/08/2017 10:25 AM
 * Current revision: 1.0.0: 1.1 $
 * <p>
 * Revision History:
 * ------------------
 */

public class Validator implements org.springframework.validation.Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
