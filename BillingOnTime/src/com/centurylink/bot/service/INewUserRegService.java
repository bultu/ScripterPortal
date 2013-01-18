package com.centurylink.bot.service;

import com.centurylink.bot.dto.UserLoginData;
import com.centurylink.bot.dto.UserPersonalDetails;



public interface INewUserRegService {
	public UserPersonalDetails getNewUserData(UserPersonalDetails udata , UserLoginData loginData);

}
