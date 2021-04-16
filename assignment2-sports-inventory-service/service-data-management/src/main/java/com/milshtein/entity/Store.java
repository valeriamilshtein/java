package com.milshtein.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor 
@NoArgsConstructor 
@Entity
//Store entity with fields
public class Store implements Serializable { //Serialization in Java allows us to convert an Object to stream that we can send over the network or save it as file or store in DB for later usage
    @Id
    private Long id;
    private String name;
    private String location;

    @OneToMany //Associates Inventory products with this specific store
    private List<Inventory> inventoryItems;
}
