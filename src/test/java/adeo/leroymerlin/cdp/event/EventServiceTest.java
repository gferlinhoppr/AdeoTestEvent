package adeo.leroymerlin.cdp.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventServiceTest {

    //Note: I considered current database as test base.

    @Autowired
    private EventService eventService;

    @Test
    void test_should_return_no_events_when_null_query_given(){
       List<EventDto> events = eventService.getFilteredEvents(null);

       assertTrue(events.isEmpty());
    }

    @Test
    void test_should_return_no_events_if_only_spaces_are_given_in_query(){
        List<EventDto> events = eventService.getFilteredEvents("    ");

        assertTrue(events.isEmpty());
    }


    @Test
    void test_should_return_no_match(){
        List<EventDto> events = eventService.getFilteredEvents("zxry");

        assertTrue(events.isEmpty());
    }

    @Test
    void test_should_return_two_events(){
        List<EventDto> events = eventService.getFilteredEvents("Hud");

        assertEquals(2, events.size());
    }


}