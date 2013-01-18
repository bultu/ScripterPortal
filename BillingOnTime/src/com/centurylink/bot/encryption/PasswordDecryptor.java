package com.centurylink.bot.encryption;
import java.lang.Math;

public class PasswordDecryptor {

	StringBuffer result = new StringBuffer();

	public String getDecryptedPassword(String Password) {
		int i = Password.length()-1;
		while(i >= 0 )
		{
			if(i== (Password.length()-1))
			{
				i= i-1;
			}
			
			int k = 0;
			int a = 0;
			int j = i;
			while(j>=0 && !(String.valueOf(Password.charAt(j)).equalsIgnoreCase("a")) && !(String.valueOf(Password.charAt(j)).equalsIgnoreCase("b")) )
			{
				a = (a +   (Integer.parseInt(String.valueOf(Password.charAt(i-k)))  *   ((int)Math.pow(10, k))));
				k++;
				j--;
			}			
			result.append((char)a);
			System.out.println(result);
			i = i-k-1;
		}
		return result.toString();	

}
}
