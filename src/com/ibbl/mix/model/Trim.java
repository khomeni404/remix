package com.ibbl.mix.model;

import com.ibbl.admin.model.Factory;
import com.ibbl.admin.model.Supplier;
import com.ibbl.common.model.GenericModel;
import org.springframework.validation.BindingResult;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright @ Soft Engine [www.soft-engine.net].
 * Created on 05-Sep-17 at 7:50 PM
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 05-Sep-17
 * Version : 1.0
 */

@Entity
@Table(name = "T24_TRIM")
public class Trim extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "po_sheet")
    private POSheet poSheet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fact")
    private Factory destination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supp")
    private Supplier source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item")
    private Item item;

    private String note;

    private String accCode;

    private String color;

    private String size;

    private Double qty;

    private Double xTra; // Extra Percentage

    // private Unit unit; // pushed to Item

    private String remarks;

    private Double poQty;

    private Integer conPerPcs;

    private Double received;

    private Boolean approved;

    private String approvalNote;

    private Boolean bbLcOpened;

    private String productionNote;

    private Date deliveryDate;

    private Double inHouseQty;

    private String inHouseNote;


    @Override
    public void validate(BindingResult result) {

    }

    @Override
    public String info() {
        return null;
    }
}
