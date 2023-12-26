# Java - Spring

## My Event

* My Event is an application to manage musical events.


## Technical stack

* This is a maven project.
* It uses HSQLDB as an in-memory database.
* It starts using this maven lifecycle ```mvn spring-boot:run``` or using the IDE
* The user interface is available at [http://localhost:8080]
* The API resources are available at [http://localhost:8080/api/] 

## Context

* The user interface is tested and holds no identified issues. 
* We Identified a few things not working on the API.
* Your job is to fix the issues and add a new feature to the API.

## Identified Issues:

```
Please keep track (notes) of how you analysed and fixed the issues to help us 
understand the steps during the interview
```

1. Adding review does not work
    * updateEvent in controller was empty.
    * I added missing getters and setters for id in Band and Member
    * I created a save method in EventRepository
    * I created an update method in EventService who called it
    * In controller, path variable id is not userful and could be removed from parameters (but would involve a front modification)

2. Using the delete button works but elements comes back when i refresh the page
   * EventRepository -> I deleted @Transactional annotation

3. No @Autowired annotations needed on constructors in Controller and Service so I deleted them.

4. name in Member was not private

5. We should use Dtos to transfer objects to front. 
   * I created dtos and mapper for each entity
   * I created a light mapping for events. This Dto does not contains groups members nor band ids since we dont need them in the page, allowing to divide file size by 2.

## New Feature
```
Except for the testing libraries, No library/modules should be added to the dependencies
(use only pure java)
```

1. We would like to enable a new route for the API `/search/{query}`. It will allow us
to display filtered `events`.
The events are displayed only if at least one band has a member with the name matching the given
pattern.

Example: `/search/Wa`
```json
[{
    "title": "GrasPop Metal Meeting",
    "imgUrl": "img/1000.jpeg",
    "bands": [{
        "name": "Metallica",
        "members": [
            {
              "name": "Queen Anika Walsh"
            }
        ]
    },…
}…]
```

2. (BONUS) Add a `[count]` at each event and band 
to display the number of child items.

Example: `/search/Wa`
```json
[{
    "title": "GrasPop Metal Meeting [2]",
    "imgUrl": "img/1000.jpeg",
    "bands": [{
        "name": "Metallica [1]",
        "members": [
            {
              "name": "Queen Anika Walsh"
            }
        ]
    },…
}…]
```

## Team Appreciation

Team overall appreciation will be based on:
- Code readability, structure and consistency
- Tests, how they are written
- Bonus: usage of Functional concepts
