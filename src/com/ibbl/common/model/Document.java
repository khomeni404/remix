package com.ibbl.common.model;

import org.springframework.validation.BindingResult;

import javax.persistence.*;

/**
 * @author Khomeni
 *         Created on : 17-May-17 at 12:52 AM
 */
@Entity
@Table(name = "T24_TRIM")
public class Document extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void validate(BindingResult result) {

    }

    @Override
    public String info() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
