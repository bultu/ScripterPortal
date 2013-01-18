package com.centurylink.bot.service.impl;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centurylink.bot.dao.impl.LoginDao;
import com.centurylink.bot.dto.UserLoginData;
import com.centurylink.bot.encryption.PasswordEncryptor;
import com.centurylink.bot.service.ILoginService;






public class LoginService implements ILoginService{

	private static Log logger  = LogFactory.getLog(LoginService.class);
	public UserLoginData getUserLoginData(String username, String password) 
	{
		UserLoginData newUserLoginData=null;
		PasswordEncryptor encPass = new PasswordEncryptor();
		encPass.setEncryptedPassword(password);
		String encryptedPassword = encPass.getEncryptedPassword();
		LoginDao loginDao = new LoginDao();
		logger.debug(password+" encrypted into "+encryptedPassword+" and sent");
		newUserLoginData =loginDao.getUserLoginData(username, encryptedPassword);
	  
	     
		return newUserLoginData;

}
}
