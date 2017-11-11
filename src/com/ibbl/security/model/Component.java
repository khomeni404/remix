package com.ibbl.security.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Khomeni
 *         Created on : 19-May-17 at 3:13 PM
 */
@Entity
@Table(name = "TAIMS_SEC_COMPONENT")
public class Component  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String prefix;

    private String description;

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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
