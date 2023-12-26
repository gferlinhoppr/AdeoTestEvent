package adeo.leroymerlin.cdp.event;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<EventDto>> findEvents() {
        return ResponseEntity.ok(eventService.getEvents());
    }

    @RequestMapping(value = "/search/{query}", method = RequestMethod.GET)
    public ResponseEntity<List<EventDto>> findEvents(@PathVariable String query) {
        return ResponseEntity.ok(eventService.getFilteredEvents(query));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateEvent(@PathVariable Long id, @RequestBody EventDto event) {
        eventService.updateEvent(event);
    }

}
