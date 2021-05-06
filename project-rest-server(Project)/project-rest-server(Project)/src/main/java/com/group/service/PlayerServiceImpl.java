package com.group.service;

import com.group.entity.Player;
import com.group.entity.PlayerUpdateDto;
import com.group.entity.Request;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class PlayerServiceImpl implements PlayerService {
    private static final int MAX_CAPACITY = 27;
    private static final int INITIAL_CAPACITY = 18;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void clearList() {
        Query deleteFromPlayer = em.createNamedQuery("Player.clearAll");
        deleteFromPlayer.executeUpdate();
    }

    public List<Player> getAllByBuilder() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Player> query = builder.createQuery(Player.class);
        Root<Player> from  = query.from(Player.class);
        TypedQuery<Player> q = em.createQuery(query.select(from));
        return q.getResultList();
    }

    @Override
    public List<Player> getPlayerList() {
        List<Player> playerList =  em.createNamedQuery("Player.findAll", Player.class)
                .getResultList();

        if (playerList.size() < MAX_CAPACITY) {
            return playerList.stream()
                    .limit(INITIAL_CAPACITY)
                    .sorted()
                    .collect(Collectors.toList());
        } else {
            return playerList.stream()
                    .limit(MAX_CAPACITY)
                    .sorted()
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Player getById(Long id) {
        return em.find(Player.class, id);
    }

    @Override
    public List<Player> getWaitList() {
        List<Player> playerList =  em.createNamedQuery("Player.findAll", Player.class)
                .getResultList();
        if (playerList.size() > INITIAL_CAPACITY && playerList.size() < MAX_CAPACITY) {
            return playerList
                    .stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(8)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Player updatePlayer(PlayerUpdateDto dto, Player playerToUpdate) {
        if (dto.getFirstName() != null) {
            playerToUpdate.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            playerToUpdate.setLastName(dto.getLastName());
        }
        em.merge(playerToUpdate);
        return playerToUpdate;
    }

    @Override
    public void addToList(Player player) {
        em.persist(player);
    }

    @Override
    public void removeFromList(Player player) {
        //Player playerWithId = em.find(Player.class, com.group.player.getId());
        Player correspondingPlayer = em
                .createNamedQuery("Player.getByLastName", Player.class)
                .setParameter("lastName", player.getLastName())
                .getSingleResult();
        em.remove(correspondingPlayer);
    }

    @Override
    public void addPlayerRequest(String lastName, Request request) {
        Player correspondingPlayer = em
                .createNamedQuery("Player.getByLastName", Player.class)
                .setParameter("lastName", lastName)
                .getSingleResult();
        request.setPlayer(correspondingPlayer);
        em.persist(request);
    }

    @Override
    public List<Request> getAllRequests() {
        return em.createNamedQuery("Request.findAll", Request.class)
                .getResultList();
    }
}
