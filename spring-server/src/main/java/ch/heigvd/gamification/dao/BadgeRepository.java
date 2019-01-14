package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.Badge;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BadgeRepository extends CrudRepository<Badge, Long> {
  
  Application findByApp(Application application);

  Badge findByNameAndApp(String name, Application application);

  List<Badge> findAll();

}
