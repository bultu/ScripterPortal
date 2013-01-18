package com.centurylink.bot.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centurylink.bot.action.LoginAction;
import com.centurylink.bot.dao.ILoginDao;
import com.centurylink.bot.db.DBManager;
import com.centurylink.bot.dto.UserLoginData;


public class LoginDao implements ILoginDao{

	private static Log logger  = LogFactory.getLog(LoginDao.class);
	String lName;
	String fName;
	@Override
	public UserLoginData getUserLoginData(String username, String password){
		// TODO Auto-generated method stub
		
		UserLoginData loginData =null;
		Connection con =null;
		try {
		DBManager db = DBManager.getMyDBManagerObject();			
		logger.debug("got connection...");
		
		con = db.getConnection();
		logger.debug(new Date());
		
		
		String query = "SELECT * FROM UserLoginData where cuId =? and password =?";

		
		PreparedStatement prs;
		
			prs = con.prepareStatement(query);
		
		prs.setString(1, username);
		prs.setString(2, password);
		ResultSet rs = prs.executeQuery();
		logger.debug("running query");
		
		

		String query2 = "SELECT * FROM UserPersonalDetails where cuId = ?";
		PreparedStatement prs1;
		prs1 = con.prepareStatement(query2);
		prs1.setString(1,username);
		ResultSet rs1 = prs1.executeQuery();
		if(rs1.next())
		{
			lName = rs1.getString("LastName");
			fName = rs1.getString("FirstName");
		}
		
		
		if(rs.next())
		{
			loginData = new UserLoginData();			
			loginData.setUsername(rs.getString("cuId") + "," + fName + " "+lName);
			loginData.setPassword(rs.getString("password"));
			loginData.setGroup(rs.getString("GroupName"));
			loginData.setStatus(rs.getInt("Status"));
			
		}
		
		
		
		
		
		logger.debug("done with query....");
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return loginData;
	}
	
}
