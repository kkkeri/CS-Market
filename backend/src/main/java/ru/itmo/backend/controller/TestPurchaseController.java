package ru.itmo.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itmo.backend.service.PurchaseService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestPurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/purchase")
    public String purchase(@RequestParam int buyerId,
                           @RequestParam int sellerId,
                           @RequestParam int inventoryItemId,
                           @RequestParam int price) {
        purchaseService.executePurchase(buyerId, sellerId, inventoryItemId, price);
        return "OK";
    }
}
