package com.centurylink.bot.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.centurylink.bot.dao.IGetUsersDao;
import com.centurylink.bot.db.DBManager;
import com.centurylink.bot.dto.UserPersonalDetails;

public class GetUsersDao implements IGetUsersDao
{

	@Override
	public ArrayList<UserPersonalDetails> getDeActivateUsers()
	{
		ArrayList<UserPersonalDetails> userDataArray = new ArrayList<UserPersonalDetails>();
		UserPersonalDetails userData = null;
		Connection con = null;
		
		try 
		{
			DBManager db = DBManager.getMyDBManagerObject();			

			con = db.getConnection();
			
			String query = "SELECT * " +
							"FROM UserPersonalDetails " +
							 "WHERE cuId IN (SELECT cuId " +
							 				 "FROM UserLoginData " +
							 				  "WHERE status = 0)";
	
			PreparedStatement prs;
			
			prs = con.prepareStatement(query);
									
			ResultSet rs = prs.executeQuery();
			
			while(rs.next())
			{
				userData = new UserPersonalDetails();			
				userData.setLastName(rs.getString("lastName"));
				userData.setFirstName(rs.getString("firstName"));
				userData.setCuId(rs.getString("cuId"));
				userData.setEmailId(rs.getString("emailId"));
				userDataArray.add(userData);
			}
			
		}
		
		catch(Exception e)
		{
			System.out.println("Query not running...");
		}
		
		finally
		{
			try
			{
				con.close();
			} 
			catch (SQLException e)
			{
				System.out.println("Connection not closed!");
			}
		}
		return userDataArray;	
	}
	
	@Override
	public ArrayList<UserPersonalDetails> getActiveUsers()
	{
		ArrayList<UserPersonalDetails> userDataArray = new ArrayList<UserPersonalDetails>();
		UserPersonalDetails userData = null;
		Connection con = null;
		
		try 
		{
			DBManager db = DBManager.getMyDBManagerObject();			

			con = db.getConnection();
			
			String query = "SELECT * " +
							"FROM UserPersonalDetails " +
							 "WHERE cuId IN (SELECT cuId " +
							 				 "FROM UserLoginData " +
							 				  "WHERE status = 1)";
	
			PreparedStatement prs;
			
			prs = con.prepareStatement(query);
									
			ResultSet rs = prs.executeQuery();
			
			while(rs.next())
			{
				userData = new UserPersonalDetails();			
				userData.setLastName(rs.getString("lastName"));
				userData.setFirstName(rs.getString("firstName"));
				userData.setCuId(rs.getString("cuId"));
				userData.setEmailId(rs.getString("emailId"));
				userDataArray.add(userData);
			}
			
		}
		
		catch(Exception e)
		{
			System.out.println("Query not running...");
		}
		
		finally
		{
			try
			{
				con.close();
			} 
			catch (SQLException e)
			{
				System.out.println("Connection not closed!");
			}
		}
		return userDataArray;	
	}

	@Override
	public Integer deActiveUsers(String username) 
	{
		Connection con = null;
		
		try 
		{
			DBManager db = DBManager.getMyDBManagerObject();			

			con = db.getConnection();
			
			String query = "UPDATE UserLoginData " +
							"SET status = 1 " +
							" WHERE cuId = ?";
	
			PreparedStatement prs;
			
			prs = con.prepareStatement(query);
			prs.setString(1, username);
			prs.executeUpdate();
			
			return 0;
		}
		
		catch(Exception e)
		{
			System.out.println("Query not running...");
			return 1;
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
	}
	
	@Override
	public Integer activeUsers(String username) 
	{
		Connection con = null;
		
		try 
		{
			DBManager db = DBManager.getMyDBManagerObject();			

			con = db.getConnection();
			
			String query = "UPDATE UserLoginData " +
							"SET status = 0 " +
							" WHERE cuId = ?";
	
			PreparedStatement prs;
			
			prs = con.prepareStatement(query);
			prs.setString(1, username);
			prs.executeUpdate();
			
			return 0;
		}
		
		catch(Exception e)
		{
			System.out.println("Query not running...");
			return 1;
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
	}
}
