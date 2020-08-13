package com.ex1cartoesapi.DTO.Request;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Component
public class CustomerRequest {
    @NotBlank
    @Size(min = 3, max = 40)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
