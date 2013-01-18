package com.centurylink.bot.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centurylink.bot.dto.UserLoginData;
import com.centurylink.bot.service.ILoginService;
import com.centurylink.bot.service.impl.LoginService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;



/**
 * Servlet implementation class LoginAction
 */
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	String cuId;
	
	public String getCuId() {
		return cuId;
	}
	public void setCuId(String cuId) {
		this.cuId = cuId;
	}

	private static Log logger  = LogFactory.getLog(LoginAction.class);
	
	String error;
	
	
	String group;
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}

	/*private UserPersonalDetails userDetails ;

	public UserPersonalDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserPersonalDetails userDetails) {
		this.userDetails = userDetails;
	}*/

	ILoginService loginService  = new LoginService();
	String name;
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getError() {
		return error;
	}



	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setError(String error) {
		this.error = error;
	}
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public String execute()
	{
		//validate();
		logger.info("=========================================Entered Method: execute() ; class: LoginAction================================================");
		

		UserLoginData userData = loginService.getUserLoginData(username, password);
		if(userData==null)
			{	
				logger.debug("null userdata!!!!!");
				error= "Wrong Credentials";
				return "input";
			}
		/*IUserFetcherService newUserService = new UserFetcherService();
		userDetails = newUserService.getUserDetails(username);*/
		group = userData.getGroup();
		name = userData.getUsername().split(",") [1];
		cuId = userData.getUsername().split(",") [0];

		/*if(userDetails==null)
		{
			return "error";
		}*/





		if(userData.getStatus() == 1)
		{
			error = "Inactive User";
			return "input";

		}
		else
			if(userData.getGroup().equalsIgnoreCase("Administrator"))
			{

				return "done";
			}
			else

			{	

				return "success";
			}
		

	}





}




