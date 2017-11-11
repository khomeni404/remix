package com.ibbl.mix.model;

import com.ibbl.common.model.GenericModel;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.validation.BindingResult;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @ Soft Engine [www.soft-engine.net].
 * Created on 05-Sep-17 at 7:50 PM
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 05-Sep-17
 * Version : 1.0
 */

@Entity
@Table(name = "T24_PO_SHEET")
public class POSheet extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "style")
    private Style style;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "poSheet")
    @Fetch(FetchMode.SELECT)
    private List<Trim> trimList = new ArrayList<>(0);


    private String aql; // Acceptable Quality Level. eg. AQL 2.5, AQL 4.0  etc

    @Override
    public void validate(BindingResult result) {

    }

    @Override
    public String info() {
        return null;
    }
}
