package com.centurylink.bot.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centurylink.bot.dto.UserLoginData;
import com.centurylink.bot.encryption.PasswordDecryptor;
import com.centurylink.bot.service.IPasswordRecoveryService;
import com.centurylink.bot.service.impl.PasswordRecoveryService;



public class ForgotPasswordAction {
	private static final long serialVersionUID = 1L;
       

		String cuId ;//= request.getParameter("phone");
		String error ;
		String page;
		String group;
		String passWord;
		String userName;
		String status;
		String emailId;
		private static Log logger  = LogFactory.getLog(ForgotPasswordAction.class);
		
		
	
		
		public String getEmailId() {
			return emailId;
		}





		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}





		public String getStatus() {
			return status;
		}





		public void setStatus(String status) {
			this.status = status;
		}





		public String getPage() {
			return page;
		}





		public void setPage(String page) {
			this.page = page;
		}





		public String getGroup() {
			return group;
		}





		public void setGroup(String group) {
			this.group = group;
		}





		public String getPassWord() {
			return passWord;
		}





		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}





		public String getUserName() {
			return userName;
		}





		public void setUserName(String userName) {
			this.userName = userName;
		}





		public String getCuId() {
			return cuId;
		}





		public void setCuId(String cuId) {
			this.cuId = cuId;
		}





		public String getError() {
			return error;
		}





		public void setError(String error) {
			this.error = error;
		}





		public String execute()
		{
			IPasswordRecoveryService passRecoveryService = new PasswordRecoveryService();
			UserLoginData userData = passRecoveryService.getUserPasswordRecovery(cuId);
			
			if(userData==null)
			{
				error = "No Such User Found";
				return "error";
			}
			PasswordDecryptor decryptedPassword = new PasswordDecryptor();
			userName = userData.getUsername();
			passWord = decryptedPassword.getDecryptedPassword(userData.getPassword());
			//emailId = userData.get;
			logger.info("Decrypted "+userData.getPassword() +"into"+ passWord + "And mailed to "+ userName );
			group = userData.getGroup().split(",") [0];
			emailId = userData.getGroup().split(",") [1];
			page="forgotpassword";
			
				
				if(userData.getStatus() == 0)
				{
					status = "Active User";
				}
				else
					status = "InActive User";
				

				return "success";
	
				}
			
		}


