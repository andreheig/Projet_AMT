package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.PointRule;
import ch.heigvd.gamification.model.PointRuleParam;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PointRuleParamRepository extends CrudRepository<PointRuleParam, Long> {

    List<PointRuleParam> findByPointRule(PointRule pointRule);

}
