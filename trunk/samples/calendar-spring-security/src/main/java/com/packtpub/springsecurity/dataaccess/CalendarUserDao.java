package com.packtpub.springsecurity.dataaccess;

import java.util.List;

import com.packtpub.springsecurity.domain.CalendarUser;

public interface CalendarUserDao {

	CalendarUser getUser(int id);

	CalendarUser findUserByEmail(String email);

	List<CalendarUser> findUsersByEmail(String partialEmail);

	int createUser(CalendarUser user);
}
