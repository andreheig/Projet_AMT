package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.BadgeThresholdRule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BadgeThresholdRuleRepository extends CrudRepository<BadgeThresholdRule, Long> {

    List<BadgeThresholdRule> findByApp(Application app);

    BadgeThresholdRule findByNameAndApp(String name, Application app);

    List<BadgeThresholdRule> findAll();
}
