package com.group.entity;

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
//League entity with fields
public class League implements Serializable { //Serialization in Java allows us to convert an Object to stream that we can send over the network or save it as file or store in DB for later usage
    @Id
    private Long id;
    private String leagueName;

    @OneToMany //Associates teams with this specific league
    private List<Team> teamList;

    @OneToMany(mappedBy = "league", fetch = FetchType.EAGER)
    private List<Request> requestList;

    public League(String leagueName, List<Team> teamList) {
        this.leagueName = leagueName;
        this.teamList = teamList;
    }

    @Override
    public String toString() {
        return "League{" +
                "leagueName='" + leagueName + '\'' +
                "teamName='" + teamList + '\'' +
                '}';
    }
}