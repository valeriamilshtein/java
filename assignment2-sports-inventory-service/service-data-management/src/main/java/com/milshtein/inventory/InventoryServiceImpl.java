package com.milshtein.inventory;
import com.milshtein.entity.Inventory;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Stateless //Implements JPA management services using stateless
@Remote(InventoryService.class) //Remote helps to pass it from one project to another
public class InventoryServiceImpl implements InventoryService {
    @PersistenceContext //Via @PersistenceContext Entity Manager communicates with Persistence Context
    private EntityManager em; //Helps to establish conversation in terms of objects and SQL terms in database

    @Override
    public List<Inventory> getInventoryList() {
        //Specifies name of query and the class it is located in
        List<Inventory> inventoryList =  em.createNamedQuery("Inventory.findAll", Inventory.class)
                .getResultList();
        return inventoryList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    @Override
    public void removeFromList(Inventory inventory) {
        //Specifies name of query and the class it is located in
        Inventory correspondingPlayer = em.createNamedQuery("Inventory.getByName", Inventory.class)
                .setParameter("name", inventory.getName())
                .getSingleResult();
        em.remove(correspondingPlayer);
    }

    @Override
    public void clearList() {
        //Specifies name of query and the class it is located in
        Query deleteFromInventory = em.createNamedQuery("Inventory.clearAll");
        deleteFromInventory.executeUpdate();
    }

    @Override
    public void addToList(Inventory inventory) {
        em.persist(inventory);
    }
}
