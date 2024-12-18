package edu.t1.task5.service;

import edu.t1.task5.entity.Limit;
import edu.t1.task5.repository.LimitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LimitServiceImpl implements edu.t1.task5.service.LimitService {
    private final LimitRepo limitRepo;

    @Autowired
    public LimitServiceImpl(LimitRepo limitRepo) {
        this.limitRepo = limitRepo;
    }

    public Limit getLimitByUserId(Long id) throws SQLException {
        Limit limit = limitRepo.getLimitByUserId(id);
        if (limit == null) {
            limit = createLimitByUserId(id);
        }
        return limit;
    }

    public Limit createLimitByUserId(Long userId) throws SQLException {
        Limit limit = new Limit(null, userId, (long)10000);
        limit = limitRepo.save(limit);
        return limit;
    }

    public Limit setLimitByUserId(Long id, Long sumLimit) throws SQLException {
        Limit limit = limitRepo.getLimitByUserId(id);
        limit.setSumLimit(sumLimit);
        limitRepo.save(limit);
        return limit;
    }

    public Limit upLimitByUserId(Long id, Long sumLimit) throws SQLException {
        Limit limit = limitRepo.getLimitByUserId(id);
        limit.setSumLimit(limit.getSumLimit()+sumLimit);
        limitRepo.save(limit);
        return limit;
    }
    public Limit downLimitByUserId(Long id, Long sumLimit) throws SQLException {
        Limit limit = limitRepo.getLimitByUserId(id);
        limit.setSumLimit(limit.getSumLimit()-sumLimit);
        limitRepo.save(limit);
        return limit;
    }

    public List<Limit> getAllBy() throws SQLException {
        return limitRepo.getAllBy();
    }

    // каждый день в 00:00 обновляем всем лимиты
    @Scheduled(cron="0 0 0 * * *")
    public void updateAllLimits() throws SQLException {
        List<Limit> allLimits= getAllBy();
        for (Limit limit : allLimits) {
            limit.setSumLimit((long)10000);
            limitRepo.save(limit);
        }
    }
}
