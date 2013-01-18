package com.centurylink.bot.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;


import com.centurylink.bot.dto.UserLoginData;
import com.centurylink.bot.dto.UserPersonalDetails;
import com.centurylink.bot.encryption.PasswordEncryptor;
import com.centurylink.bot.service.INewUserRegService;
import com.centurylink.bot.service.impl.NewUserService;
import com.opensymphony.xwork2.ActionSupport;


public class NewUserRegAction extends ActionSupport {
	
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		String lastName;
		String firstName;
		String cuId;
		String emailId;
		String groupName;
		String password;
		String page;
		private static Log logger  = LogFactory.getLog(NewUserRegAction.class);
		
	



		

		public String getPage() {
			return page;
		}





		public void setPage(String page) {
			this.page = page;
		}





		public String getGroupName() {
			return groupName;
		}





		public void setGroupName(String groupName) {
			this.groupName = groupName;
		}





		public String getPassword() {
			return password;
		}





		public void setPassword(String password) {
			this.password = password;
		}








		public String getLastName() {
			return lastName;
		}





		public void setLastName(String lastName) {
			this.lastName = lastName;
		}





		public String getFirstName() {
			return firstName;
		}





		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}





		public String getCuId() {
			return cuId;
		}





		public void setCuId(String cuId) {
			this.cuId = cuId;
		}





		public String getEmailId() {
			return emailId;
		}





		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}





		public String execute()
		{
			logger.info("=========================================Entered Method: execute() ; class: NewUserRegAction================================================");
			page="newuser";
			if(groupName.equalsIgnoreCase(String.valueOf(1)))
			{
				groupName = "Regular User";
			}
			else
				if(groupName.equalsIgnoreCase(String.valueOf(2)))
				{
					groupName = "Administrator";
				}
				
			UserPersonalDetails uData = new UserPersonalDetails();
			UserLoginData loginData = new UserLoginData();
			uData.setLastName(lastName);
			uData.setFirstName(firstName);
			uData.setEmailId(emailId);
			uData.setCuId(cuId);
			
			PasswordEncryptor encPass = new PasswordEncryptor();
			encPass.setEncryptedPassword(password);
			String encryptedPassword = encPass.getEncryptedPassword();
			
			loginData.setGroup(groupName);
			loginData.setPassword(encryptedPassword);
			loginData.setUsername(cuId);
			loginData.setStatus(0);			// 1-> inactiver user   ;  0 -> active user
			
			logger.debug(password+" encrypted into "+encryptedPassword+" and sent for new user registration");
		
		INewUserRegService newUserService = new NewUserService();
		UserPersonalDetails userData = newUserService.getNewUserData(uData , loginData);
		
		
		if(userData==null)
		{
			return "error";
		}
		else
			{
			logger.debug("------new user registration done------");
			ServletActionContext.getRequest().setAttribute("LastName",userData.getLastName());
			ServletActionContext.getRequest().setAttribute("FirstName",userData.getFirstName());
			ServletActionContext.getRequest().setAttribute("CuId",userData.getCuId());
			ServletActionContext.getRequest().setAttribute("EmailId",userData.getEmailId());
			return "success";
			}
			
		
	}
}




/*
		public NewUserReg() {
			NewUserRegDao groupFetcher = new NewUserRegDao();
			groupList = new ArrayList<String>();
			List<String> gl = new ArrayList<String>();
			gl = groupFetcher.getGroupNames();
			Iterator<String> il = gl.iterator();
			while(il.hasNext())
			{
				
				String groupName = il.next();
				System.out.println(groupName);
				groupList.add(groupName);
			}
			
			// TODO Auto-generated constructor stub
			
		}
		
		public String display() {
			return "none";
		}*/



