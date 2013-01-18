package com.centurylink.bot.dao;

import com.centurylink.bot.dto.UserLoginData;





public interface IPaswordRecoveryDao {
	public UserLoginData getUserLoginData(String cuID);

}
