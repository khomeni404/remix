package com.ibbl.mix.model;

import com.ibbl.common.model.Document;
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
@Table(name = "T24_UNIT")
public class Unit extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name; // Kilogram, Gross, PCS etc.

    private String description;

    private String intSign; // International Sign. e.g. kg, Oz, lb, cm, sft etc.

    
    @Override
    public void validate(BindingResult result) {

    }

    @Override
    public String info() {
        return name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
