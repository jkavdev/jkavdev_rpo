package com.packtpub.springsecurity.dataaccess;

import java.util.List;

import com.packtpub.springsecurity.domain.Event;

public interface EventDao {

	Event getEvent(int eventId);

	int createEvent(Event event);

	List<Event> findForUser(int userId);

	List<Event> getEvents();
}
