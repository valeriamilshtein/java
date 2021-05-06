package com.group.service;

import com.group.entity.Player;
import com.group.entity.PlayerUpdateDto;
import com.group.entity.Team;
import com.group.entity.TeamUpdateDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class TeamServiceImpl implements TeamService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Team getById(Long id) {
        return em.find(Team.class, id);
    }

    @Override
    public void addToList(Team team) {
        em.persist(team);
    }

    @Override
    public Team updateTeam(TeamUpdateDto dto, Team teamToUpdate) {
        if (dto.getTeamName() != null) {
            teamToUpdate.setTeamName(dto.getTeamName());
        }
        em.merge(teamToUpdate);
        return teamToUpdate;
    }
}
