package ru.itmo.backend.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BalanceDao {

    private final JdbcTemplate jdbcTemplate;

    public boolean checkBalance(int userId, int amount) {
        log.info("Calling check_user_balance(userId={}, amount={})", userId, amount);
        Boolean result = jdbcTemplate.queryForObject(
                "SELECT check_user_balance(?, ?)",
                Boolean.class,
                userId,
                amount
        );

        boolean ok = Boolean.TRUE.equals(result);
        log.info("check_user_balance result={}", ok);
        return ok;
    }
}
