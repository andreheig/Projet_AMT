package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.PointRule;
import ch.heigvd.gamification.model.Rule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PointRuleRepository extends CrudRepository<PointRule, Long> {
  
  Application findByApp(Application app);

  PointRule findByNameAndApp(String Name, Application app);

  List<PointRule> findAll();

}
