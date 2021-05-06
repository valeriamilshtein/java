package com.group.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p")
@NamedQuery(name = "Player.getByLastName", query = "SELECT p from Player p where p.lastName = :lastName")
@NamedQuery(name = "Player.clearAll", query = "DELETE FROM Player")
//Player entity with fields
public class Player implements Comparable<Player>, Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String firstName;
    private String lastName;
    private Date signedUpDate;
    private Date dateOfBirth;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    private List<Request> requestList;

    @PrePersist
    void createdAt() {
        this.signedUpDate = new Date();
        this.dateOfBirth = new Date();
    }

    @PreUpdate
    void updatedAt() {
        this.signedUpDate = new Date();
        this.dateOfBirth = new Date();
    }

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Player o) {
        return signedUpDate.compareTo(o.signedUpDate);
    }
}
