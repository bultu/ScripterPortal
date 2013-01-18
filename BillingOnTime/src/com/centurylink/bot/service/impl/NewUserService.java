package com.centurylink.bot.service.impl;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.centurylink.bot.dao.impl.NewUserRegDao;
import com.centurylink.bot.dto.UserLoginData;
import com.centurylink.bot.dto.UserPersonalDetails;
import com.centurylink.bot.service.INewUserRegService;





public class NewUserService implements INewUserRegService{

	@Override
	public UserPersonalDetails getNewUserData(UserPersonalDetails udata , UserLoginData loginData) {
			NewUserRegDao newUserDao = new NewUserRegDao();
			UserPersonalDetails newUserLoginData=null;
			newUserLoginData =newUserDao.getNewUserData(udata , loginData);
		  
		    
			return newUserLoginData;

}
}
