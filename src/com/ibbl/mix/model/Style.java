package com.ibbl.mix.model;

import com.ibbl.common.model.GenericModel;
import org.springframework.validation.BindingResult;

import javax.persistence.*;

/**
 * Copyright @ Soft Engine [www.soft-engine.net].
 * Created on 05-Sep-17 at 7:50 PM
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 05-Sep-17
 * Version : 1.0
 */

@Entity
@Table(name = "T24_STYLE")
public class Style extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "style")
    private POSheet poSheet;
    
    @Override
    public void validate(BindingResult result) {

    }

    @Override
    public String info() {
        return null;
    }
}
