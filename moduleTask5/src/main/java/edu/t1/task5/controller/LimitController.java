package edu.t1.task5.controller;

import edu.t1.task5.entity.Limit;
import edu.t1.task5.service.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/limit")
public class LimitController {
    LimitService limitService;

    @Autowired
    public LimitController(LimitService limitService) {
        this.limitService = limitService;
    }

    @GetMapping(value = "/getLimit/{userId}")
    public Limit getLimitByUserId(@PathVariable("userId") Long userId) throws SQLException {
        return limitService.getLimitByUserId(userId);
    }

    @GetMapping(value = "/createLimit/{userId}")
    public Limit createLimitByUserId(@PathVariable("userId") Long userId) throws SQLException {
        return limitService.createLimitByUserId(userId);
    }

    @GetMapping(value = "/setLimitByUserId/{userId}/{sumLimit}")
    public Limit setLimitByUserId(@PathVariable("userId") Long userId, @PathVariable("sumLimit") Long sumLimit) throws SQLException {
        return limitService.setLimitByUserId(userId, sumLimit);
    }

    @GetMapping(value = "/upLimitByUserId/{userId}/{sumLimit}")
    public Limit upLimitByUserId(@PathVariable("userId") Long userId, @PathVariable("sumLimit") Long sumLimit) throws SQLException {
        return limitService.upLimitByUserId(userId, sumLimit);
    }

    @GetMapping(value = "/downLimitByUserId/{userId}/{sumLimit}")
    public Limit downLimitByUserId(@PathVariable("userId") Long userId, @PathVariable("sumLimit") Long sumLimit) throws SQLException {
        return limitService.downLimitByUserId(userId, sumLimit);
    }

}
