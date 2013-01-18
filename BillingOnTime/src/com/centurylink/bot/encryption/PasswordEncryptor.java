package com.centurylink.bot.encryption;

import java.util.ArrayList;

import java.util.List;



public class PasswordEncryptor {
	//private int[] encryptedPassword;
	//private List<Integer> encryptedPassword = new ArrayList<Integer>();
	StringBuffer encPass = new StringBuffer();

	public String getEncryptedPassword() {
		//Integer.toBinaryString((int)encryptedPassword)
		return encPass.toString();
		
	}

	public void setEncryptedPassword(String Password) {
		 //Iterator<Integer> passwordStream = encryptedPassword.iterator();
		
		 int i = Password.length();
		 while(i>0)
		 {
			 //encryptedPassword.add((int) Password.charAt(--i));
			 encPass.append((int)Password.charAt(--i));
			 if(i % 2 == 0)
				 encPass.append("a");
			 else
				 encPass.append("b");
			 
		 }
		 
		 
	}
	
	
	
	

}
