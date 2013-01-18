package com.centurylink.bot.service;

import com.centurylink.bot.dto.UserLoginData;






public interface IPasswordRecoveryService {
	public UserLoginData getUserPasswordRecovery(String cuId);

}
