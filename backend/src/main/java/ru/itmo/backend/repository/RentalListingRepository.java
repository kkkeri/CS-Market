package ru.itmo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.backend.model.RentalListing;

import java.util.List;

public interface RentalListingRepository extends JpaRepository<RentalListing, Integer> {
    List<RentalListing> findByInventoryItemId(Integer inventoryItemId);
}