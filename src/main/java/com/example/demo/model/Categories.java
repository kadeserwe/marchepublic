package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="Categories")
public class Categories implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String description;

    public Categories() { }

    public Categories(Long id,  String description) {
        this.id = id;

        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
