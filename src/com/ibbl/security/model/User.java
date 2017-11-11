package com.ibbl.security.model;

import com.ibbl.common.model.GenericModel;
import org.springframework.validation.BindingResult;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Khomeni
 *         Created on : 18-May-17 at 1:12 AM
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Table(name= "TAIMS_SEC_LOGGED_USERS")
public class User extends GenericModel implements Serializable{

    private static final long serialVersionUID = 7389991231663740924L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Name is Required")
    @Size(min = 3, max = 100, message = "Length must between 3 - 100 Character")
    @Column(length = 100, name = "name")
    private String name;


    @Transient
    public String getDiscriminatorValue(){
        DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );
        return val == null ? this.getClass().getSimpleName() : val.value();
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public void validate(BindingResult result) {

    }

    @Override
    public String info() {
        return null;
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

}
