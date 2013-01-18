package com.centurylink.bot.dao;

import java.util.ArrayList;

import com.centurylink.bot.dto.UserPersonalDetails;


public interface IGetUsersDao
{
	public ArrayList<UserPersonalDetails> getDeActivateUsers();
	public ArrayList<UserPersonalDetails> getActiveUsers();
	public Integer deActiveUsers(String username);
	public Integer activeUsers(String username);
}
