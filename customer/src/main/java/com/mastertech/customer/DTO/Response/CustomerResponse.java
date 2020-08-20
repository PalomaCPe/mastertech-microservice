package com.mastertech.customer.DTO.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerResponse {
    private Integer id;

    @JsonProperty("nome")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
