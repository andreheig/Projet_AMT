package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.Application;
import java.util.List;

import ch.heigvd.gamification.model.Badge;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
  
  Application findByName(String name);

  Application findByKeyUUID(String uuid);


}
