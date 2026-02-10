package ru.itmo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.backend.model.RentalContract;

import java.util.List;

public interface RentalContractRepository extends JpaRepository<RentalContract, Integer> {
    List<RentalContract> findByRentalListingId(Integer rentalListingId);
    List<RentalContract> findByTransactionId(Integer transactionId);
}