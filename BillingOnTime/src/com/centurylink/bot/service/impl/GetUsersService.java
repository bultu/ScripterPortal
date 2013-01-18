package com.centurylink.bot.service.impl;

import java.util.ArrayList;

import com.centurylink.bot.dao.IGetUsersDao;
import com.centurylink.bot.dao.impl.GetUsersDao;
import com.centurylink.bot.dto.UserPersonalDetails;
import com.centurylink.bot.service.IGetUsersService;

public class GetUsersService implements IGetUsersService
{
	IGetUsersDao getUsersDao = null;

	@Override
	public ArrayList<UserPersonalDetails> getDeActiveUsers()
	{
		getUsersDao = new GetUsersDao();
		return getUsersDao.getDeActivateUsers();
	}

	@Override
	public ArrayList<UserPersonalDetails> getActiveUsers() 
	{
		getUsersDao = new GetUsersDao();
		return getUsersDao.getActiveUsers();
	}

	@Override
	public Integer deActiveUsers(String username) 
	{
		getUsersDao = new GetUsersDao();
		return getUsersDao.deActiveUsers(username);
	}

	@Override
	public Integer activeUsers(String username)
	{
		getUsersDao = new GetUsersDao();
		return getUsersDao.activeUsers(username);
	}
}
