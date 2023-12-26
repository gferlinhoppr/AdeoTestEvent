package adeo.leroymerlin.cdp.event;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends Repository<Event, Long> {

    void deleteById(Long eventId);

    List<Event> findAllBy();

    void save(Event event);

    Optional<Event> findById(Long id);
}
