package ru.itmo.backend.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PurchaseDao {
    private final JdbcTemplate jdbcTemplate;

    public void executePurchase(int buyerId, int sellerId, int inventoryItemId, int price) {
        log.info("Calling execute_purchase(buyerId={}, sellerId={}, inventoryItemId={}, price={})",
                buyerId, sellerId, inventoryItemId, price);

        try {
            jdbcTemplate.update("CALL execute_purchase(?, ?, ?, ?)", buyerId, sellerId, inventoryItemId, price);

            log.info("execute_purchase finished OK");
        } catch (DataAccessException e) {
            String msg = e.getRootCause() != null ? e.getRootCause().getMessage() : e.getMessage();
            log.warn("execute_purchase failed: {}", msg);
            throw e;
        }
    }
}
