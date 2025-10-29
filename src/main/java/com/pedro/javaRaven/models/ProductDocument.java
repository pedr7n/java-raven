package com.pedro.javaRaven.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDocument implements Serializable{

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;
    private BigDecimal value;

    public ProductDocument() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
