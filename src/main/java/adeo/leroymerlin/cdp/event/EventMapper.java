package adeo.leroymerlin.cdp.event;

import adeo.leroymerlin.cdp.band.BandMapper;
import java.util.LinkedList;
import java.util.List;

public class EventMapper {

    public static EventDto toEventDto(Event event, boolean lightDto){
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setComment(event.getComment());
        eventDto.setTitle(event.getTitle());
        eventDto.setNbStars(event.getNbStars());
        eventDto.setImgUrl(event.getImgUrl());

        eventDto.setBands(BandMapper.toBandDtos(event.getBands(), lightDto));

        return eventDto;
    }

    public static EventDto toEventDtoWithFilterMember(Event event, String filterMember){
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setComment(event.getComment());

        eventDto.setNbStars(event.getNbStars());
        eventDto.setImgUrl(event.getImgUrl());

        eventDto.setBands(BandMapper.toBandDtosWithFilterMember(event.getBands(), filterMember));

        var bandNumber = String.format(" [%d]", eventDto.getBands().size());

        eventDto.setTitle(event.getTitle() + bandNumber);

        return eventDto;
    }

    public static List<EventDto> toEventDtos(Iterable<Event> events, boolean lightDto){
        List<EventDto> eventDtos = new LinkedList<>();

        events.forEach(event -> eventDtos.add(toEventDto(event, lightDto)));

        return eventDtos;
    }

    public static List<EventDto> toEventDtosWithFilterMember(Iterable<Event> events,  String filterMember){
        List<EventDto> eventDtos = new LinkedList<>();

        events.forEach(event -> eventDtos.add(toEventDtoWithFilterMember(event, filterMember)));

        return eventDtos;
    }

    public static void mapFromDtoToEntity(EventDto eventDto, Event event){

        event.setId(eventDto.getId());
        event.setComment(eventDto.getComment());
        event.setTitle(eventDto.getTitle());
        event.setNbStars(eventDto.getNbStars());
        event.setImgUrl(eventDto.getImgUrl());

    }

}
