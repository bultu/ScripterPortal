package com.centurylink.bot.dao;

import com.centurylink.bot.dto.UserLoginData;

//import java.sql.SQLException;


public interface ILoginDao 
{
	public UserLoginData getUserLoginData(String username , String password);

}
