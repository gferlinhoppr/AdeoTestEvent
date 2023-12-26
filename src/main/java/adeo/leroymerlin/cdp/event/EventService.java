package adeo.leroymerlin.cdp.event;

import adeo.leroymerlin.cdp.band.Band;
import adeo.leroymerlin.cdp.member.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class EventService {

    private static final String EMPTY_STRING = "";

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventDto> getEvents() {
        return EventMapper.toEventDtos(eventRepository.findAllBy(), true);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    public void updateEvent(EventDto eventDto){

        Optional<Event> event = eventRepository.findById(eventDto.getId());

        EventMapper.mapFromDtoToEntity(eventDto, event.orElseThrow());

        eventRepository.save(event.get());
    }

    public List<EventDto> getFilteredEvents(String query) {
        List<Event> events = List.of();

        if(!isEmptyQuery(query)) {
            events = eventRepository.findAllBy();

            events = events
                    .stream()
                    .filter(
                            getEventPredicate(query)
                    ).collect(Collectors.toList());

        }

        return EventMapper.toEventDtosWithFilterMember(events, query);
    }

    private Predicate<Event> getEventPredicate(String query) {
        return event -> event
                            .getBands()
                            .stream()
                            .anyMatch(getBandPredicate(query));
    }

    private Predicate<Band> getBandPredicate(String query) {
        return band -> band
                .getMembers()
                .stream()
                .anyMatch(getMemberPredicate(query));
    }

    private Predicate<Member> getMemberPredicate(String query) {
        return member -> member
                .getName()
                .toLowerCase()
                .contains(query.toLowerCase());
    }

    private boolean isEmptyQuery(String query){
        return query == null || EMPTY_STRING.equals(query.trim());
    }

}
