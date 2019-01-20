package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.api.dto.BadgeTimeRangeRuleDto;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.Badge;
import ch.heigvd.gamification.model.BadgeTimeRangeRule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BadgeTimeRangeRuleRepository extends CrudRepository<BadgeTimeRangeRule, Long> {

  List<BadgeTimeRangeRule> findByApp(Application application);

  BadgeTimeRangeRule findByNameAndApp(String name, Application application);

  List<BadgeTimeRangeRule> findByAppAndSecondEventType(Application application, String secondEventType);

  List<BadgeTimeRangeRule> findAll();

}
