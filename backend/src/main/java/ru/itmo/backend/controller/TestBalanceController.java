package ru.itmo.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itmo.backend.dao.BalanceDao;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestBalanceController {
    private final BalanceDao balanceDao;

    @GetMapping("/balance-check")
    public boolean balanceCheck(@RequestParam int userId, @RequestParam int amount) {
        return balanceDao.checkBalance(userId, amount);
    }
}
