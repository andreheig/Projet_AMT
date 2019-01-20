package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.EndUser;
import ch.heigvd.gamification.model.EventHistory;
import org.springframework.data.repository.CrudRepository;

public interface EventHistoryRepository  extends CrudRepository<EventHistory, Long> {
    EventHistory findByUserAndEventType(EndUser user, String eventType);
}
