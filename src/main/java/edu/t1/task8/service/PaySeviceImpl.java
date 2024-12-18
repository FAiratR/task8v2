package edu.t1.task8.service;

import edu.t1.task8.entity.Pay;
import edu.t1.task8.repository.Payable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service
public class PaySeviceImpl implements PayService{
    Payable payable;

    @Autowired
    public PaySeviceImpl(Payable payable) {
        this.payable = payable;
    }

    public String payExecute(Long userId, Long productId, Long count) throws SQLException {
        Pay pay = new Pay(null,productId,count,userId);
        payable.save(pay);
        return "Ok";
    }
}
