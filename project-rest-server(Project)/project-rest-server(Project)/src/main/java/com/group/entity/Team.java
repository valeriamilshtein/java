package com.group.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//Team entity with fields
public class Team implements Serializable { //Serialization in Java allows us to convert an Object to stream that we can send over the network or save it as file or store in DB for later usage
    @Id
    private Long id;
    private String teamName;
    private Time nextGame; //time of the next game
    private String league; //league it participates in

    @OneToMany //Associates players with this specific team
    private List<Player> playerList;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private List<Request> requestList;

    public Team(String teamName, Time nextGame, String league) {
        this.teamName = teamName;
        this.nextGame = nextGame;
        this.league = league;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", nextGame='" + nextGame + '\'' +
                ", league='" + league + '\'' +
                '}';
    }
}


