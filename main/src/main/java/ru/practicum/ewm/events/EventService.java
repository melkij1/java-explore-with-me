package ru.practicum.ewm.events;

import jakarta.servlet.http.HttpServletRequest;
import ru.practicum.ewm.events.dto.*;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
    EventFullDto addEvent(Long userId, EventNewDto eventNewDto);

    EventFullDto updateEventByOwner(Long userId, Long eventId, EventUpdateUserDto updateEvent);

    EventFullDto updateEventByAdmin(Long eventId, EventUpdateAdminDto updateEvent);

    List<EventShortDto> getEventsByOwner(Long userId, Integer from, Integer size);

    EventFullDto getEventByOwner(Long userId, Long eventId);

    List<EventFullDtoWithViews> getEventsByAdminParams(List<Long> users, List<String> states, List<Long> categories,
                                                              LocalDateTime rangeStart, LocalDateTime rangeEnd,
                                                              Integer from, Integer size);

    List<EventShortDtoWithViews> getEvents(String text, List<Long> categories, Boolean paid, LocalDateTime rangeStart,
                                                  LocalDateTime rangeEnd, Boolean onlyAvailable, String sort, Integer from,
                                                  Integer size, HttpServletRequest request);


    EventFullDtoWithViews getEventById(Long eventId, HttpServletRequest request);
}
