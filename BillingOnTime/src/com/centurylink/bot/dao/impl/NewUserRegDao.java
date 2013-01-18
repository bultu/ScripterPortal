package com.centurylink.bot.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.centurylink.bot.dao.INewUserRegDao;
import com.centurylink.bot.db.DBManager;
import com.centurylink.bot.dto.UserLoginData;
import com.centurylink.bot.dto.UserPersonalDetails;


public class NewUserRegDao implements INewUserRegDao{

	@Override
	public UserPersonalDetails getNewUserData(UserPersonalDetails udata, UserLoginData loginData) {
		
		UserPersonalDetails userData =null;
		//UserLoginData userLoginData = null;
		Connection con =null;
		try {
		DBManager db = DBManager.getMyDBManagerObject();			
		
		
		con = db.getConnection();
		//System.out.println(new Date());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd /yy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		//String query1 = "INSERT INTO UserLoginData VALUES(?,?,?,?,)";
		String query = "INSERT INTO UserPersonalDetails VALUES(?,?,?,?)";

		
		PreparedStatement prs;
		prs = con.prepareStatement(query);
		
		prs.setString(1, udata.getCuId());
		prs.setString(2, udata.getLastName());
		prs.setString(3, udata.getFirstName());
		prs.setString(4, udata.getEmailId());		
		
		prs.executeUpdate();
		
		
		String query2 = "INSERT INTO UserLoginData VALUES (?,?,?,?)";
		PreparedStatement prs2;
		prs2 = con.prepareStatement(query2);
		
		prs2.setString(1, loginData.getUsername());
		prs2.setString(2, loginData.getPassword());
		prs2.setString(3, loginData.getGroup());
		prs2.setInt(4, loginData.getStatus());		
		
		prs2.executeUpdate();
		
		
		
		String queryCheck = "SELECT * FROM UserPersonalDetails WHERE cuId =?";
		PreparedStatement prsCheck;
		
		prsCheck = con.prepareStatement(queryCheck);
	
		prsCheck.setString(1, udata.getCuId());

	
	
		ResultSet rs = prsCheck.executeQuery();
		
		if(rs.next())
		{
			userData = new UserPersonalDetails();
			userData.setCuId(rs.getString("cuId"));
			userData.setLastName(rs.getString("LastName"));
			userData.setFirstName(rs.getString("FirstName"));
			userData.setEmailId(rs.getString("EmailId"));

			
		}
		
			
		
	}
	catch(SQLException e)
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
		return userData;

	}

}
