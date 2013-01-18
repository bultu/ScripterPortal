package com.centurylink.bot.dao;

import com.centurylink.bot.dto.UserLoginData;
import com.centurylink.bot.dto.UserPersonalDetails;



public interface INewUserRegDao {
	public UserPersonalDetails getNewUserData(UserPersonalDetails udata , UserLoginData loginData);

}
