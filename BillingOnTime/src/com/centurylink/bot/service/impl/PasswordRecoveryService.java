package com.centurylink.bot.service.impl;

import com.centurylink.bot.dao.IPaswordRecoveryDao;
import com.centurylink.bot.dao.impl.PasswordRecoveryDao;
import com.centurylink.bot.dto.UserLoginData;
import com.centurylink.bot.service.IPasswordRecoveryService;



public class PasswordRecoveryService implements IPasswordRecoveryService{

	@Override
	public UserLoginData getUserPasswordRecovery(String cuID) {
		/*// TODO Auto-generated method stub
		IPaswordRecoveryDao loginDao = new PasswordRecoveryDao();
		return loginDao.getUserLoginData(phone, email);*/
		IPaswordRecoveryDao passRecoveryDao = new PasswordRecoveryDao();
		{
			
			UserLoginData newUserLoginData=null;
			newUserLoginData =passRecoveryDao.getUserLoginData(cuID);
		  
		    
			return newUserLoginData;
	}

}
}
