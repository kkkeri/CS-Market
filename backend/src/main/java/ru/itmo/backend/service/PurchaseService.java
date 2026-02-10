package ru.itmo.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.itmo.backend.dao.PurchaseDao;
import ru.itmo.backend.exception.BadRequestException;
import ru.itmo.backend.exception.InsufficientFundsException;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseDao dao;

    public void executePurchase(int buyerId, int sellerId, int inventoryItemId, int price) {
        try {
            dao.executePurchase(buyerId, sellerId, inventoryItemId, price);
        } catch (DataAccessException e) {
            String msg = (e.getRootCause() != null) ? e.getRootCause().getMessage() : e.getMessage();
            String lower = (msg == null) ? "" : msg.toLowerCase();

            if (lower.contains("insufficient funds")) {
                throw new InsufficientFundsException("Insufficient funds");
            }

            if (lower.contains("not found")
                    || lower.contains("price mismatch")
                    || lower.contains("not owned")
                    || lower.contains("invalid price")
                    || lower.contains("active sale listing")) {
                throw new BadRequestException(msg != null ? msg : "Bad request");
            }

            throw e;
        }
    }
}
