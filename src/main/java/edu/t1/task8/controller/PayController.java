package edu.t1.task8.controller;

import edu.t1.task5.entity.Limit;
import edu.t1.task5.entity.Product;
import edu.t1.task5.entity.User;
import edu.t1.task8.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PayController {
    @Autowired
    private PayService payService;

    @GetMapping("/payService/payExecute/{userId}/{sumPay}/{productId}/{count}")
    public String payExecute(@PathVariable("userId")Long userId
                                , @PathVariable("sumPay")Long sumPay
                                , @PathVariable("productId")Long productId
                                , @PathVariable("count")Long count) throws SQLException {
        RestClient restClient = RestClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
        Limit limit;

        // ищем лимит пользователя
        // если лимит не найден, то создаем
        limit = restClient
                .get()
                .uri("/limit/getLimit/" + userId)
                .retrieve().body(Limit.class);

        //уменьшаем лимит
        limit = restClient
                .get()
                .uri("/limit/downLimitByUserId/" + userId+"/"+sumPay)
                .retrieve().body(Limit.class);
        try {
            // создаем платеж
            if (limit.getSumLimit() > 0 && sumPay <= limit.getSumLimit()) {
                String res = payService.payExecute(limit.getUserId(), productId, count);
            }
            return limit.toString();
        }
        catch (Exception e) {
            // если какая-то ошибка, восстанавливаем лимит
            limit = restClient
                    .get()
                    .uri("/limit/upLimitByUserId/" + userId + "/" + sumPay)
                    .retrieve().body(Limit.class);

            return e.getMessage();
        }
    }

    @GetMapping("/payService/getAllProduct/{userId}")
    public List<Product> getAllProducts(@PathVariable("userId")Long userId) throws SQLException {
        RestClient restClient = RestClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
        List<Product> products =
                restClient
                        .get()
                        .uri("/product/getAllProduct/"+userId)
                        .retrieve()
                        .body(List.class);
        return products;
    }

}
