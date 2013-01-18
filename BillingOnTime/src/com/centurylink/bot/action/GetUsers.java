package com.centurylink.bot.action;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centurylink.bot.service.IGetUsersService;
import com.centurylink.bot.service.impl.GetUsersService;
import com.centurylink.bot.dto.UserPersonalDetails;
import com.opensymphony.xwork2.ActionSupport;

public class GetUsers extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private static Log logger  = LogFactory.getLog(GetUsers.class);
	private String username;
	private String error;
	private ArrayList<UserPersonalDetails> userDataArray;
	
	IGetUsersService getUsersService = null;
	
    public GetUsers()
    {
        super();
    }
    
    public String getUsername()
    {
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getError() 
	{
		return error;
	}

	public void setError(String error) 
	{
		this.error = error;
	}
	
	public ArrayList<UserPersonalDetails> getUserDataArray()
	{
		return userDataArray;
	}

	public void setUserDataArray(ArrayList<UserPersonalDetails> userDataArray)
	{
		this.userDataArray = userDataArray;
	}

	public String getDeActiveUsers()
	{
		getUsersService = new GetUsersService();
		userDataArray= new ArrayList<UserPersonalDetails>();
		userDataArray = getUsersService.getDeActiveUsers();				////status - 0 - Active user list
		
		if(userDataArray == null)
		{	
			logger.debug("null userdata!!!!!");
			error = "No active users present";
			return "error";
		}
				
		return "success";
	}
	
	public String getActiveUsers()
	{
		getUsersService = new GetUsersService();
		userDataArray= new ArrayList<UserPersonalDetails>();
		userDataArray = getUsersService.getActiveUsers();	///status - 1 - Inactive user list
		
		if(userDataArray == null)
		{	
			logger.debug("null userdata!!!!!");
			error = "No Inactive users present";
			return "error";
		}
				
		return "success";
	}
	
	public String deActiveUsers()
	{
		getUsersService = new GetUsersService();
		Integer status = getUsersService.deActiveUsers(username);
		
		if(status == 1)
		{	
			logger.debug("null userdata!!!!!");
			error = "User already de-activated!";
			return "error";
		}
				
		return "success";
	}
	
	public String activeUsers()
	{
		getUsersService = new GetUsersService();
		Integer status = getUsersService.activeUsers(username);
		
		if(status == 1)
		{	
			logger.debug("null userdata!!!!!");
			error = "User already activated!";
			return "error";
		}
				
		return "success";
	}
}
