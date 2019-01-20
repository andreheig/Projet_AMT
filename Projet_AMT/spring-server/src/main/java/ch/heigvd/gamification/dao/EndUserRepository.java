package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.EndUser;
import org.springframework.data.repository.CrudRepository;

public interface EndUserRepository extends CrudRepository<EndUser, Long>{

  EndUser findByAppNameAndIdInGamifiedApplication(String appName, String userId);
  
}
