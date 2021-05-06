package com.group.service;

import com.group.entity.League;
import com.group.entity.Player;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LeagueServiceImpl implements LeagueService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addToList(League league) {
        em.persist(league);
    }
}