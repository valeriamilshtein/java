package com.milshtein.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")
@NamedQuery(name = "Inventory.getByName", query = "SELECT i FROM Inventory  i WHERE i.name = :name")
@NamedQuery(name = "Inventory.clearAll", query = "DELETE FROM Inventory ")
//Inventory entity with fields
public class Inventory implements Comparable<Inventory>, Serializable { //Serialization in Java allows us to convert an Object to stream that we can send over the network or save it as file or store in DB for later usage
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String sport;
    private int quantity;
    private double unitPrice;
    private Date dateUpdated;

    @PrePersist
    void createdAt() {
        this.dateUpdated = new Date();
    }

    @PreUpdate //Helps to set generated areas
    void updatedAt() {
        this.dateUpdated = new Date();
    }

    @Override
    public int compareTo(Inventory o) {
        return dateUpdated.compareTo(o.dateUpdated);
    }
}
