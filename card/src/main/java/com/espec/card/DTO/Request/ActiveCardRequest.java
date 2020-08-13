package com.ex1cartoesapi.DTO.Request;

import javax.validation.constraints.NotNull;

public class ActiveCardRequest {
    @NotNull
    private Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
