package com.ex1cartoesapi.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer implements Serializable {
    private static final long serialVersionUID = -8026843854427060306L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message =  "Nome deve ser preenchido")
    @NotBlank(message = "Nome deve ser preenchido")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
