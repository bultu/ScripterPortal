package com.centurylink.bot.service;

import java.util.ArrayList;

import com.centurylink.bot.dto.UserPersonalDetails;


public interface IGetUsersService
{
	public ArrayList<UserPersonalDetails> getDeActiveUsers();
	public ArrayList<UserPersonalDetails> getActiveUsers();
	public Integer deActiveUsers(String username);
	public Integer activeUsers(String username);
}
