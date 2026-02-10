package ru.itmo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.backend.model.InventoryItem;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Integer> {
}
