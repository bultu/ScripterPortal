package com.centurylink.bot.service;

import com.centurylink.bot.dto.UserLoginData;



public interface ILoginService 
{
	public UserLoginData getUserLoginData(String username, String password);
}
