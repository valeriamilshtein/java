package com.milshtein.inventory;
import com.milshtein.entity.Inventory;

import java.util.List;

public interface InventoryService {
    void clearList();
    List<Inventory> getInventoryList();
    void addToList(Inventory inventory);
    void removeFromList(Inventory inventory);
}
