package com.centurylink.bot.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centurylink.bot.dao.IPaswordRecoveryDao;
import com.centurylink.bot.db.DBManager;
import com.centurylink.bot.dto.UserLoginData;



public class PasswordRecoveryDao implements IPaswordRecoveryDao{

	private static Log logger  = LogFactory.getLog(PasswordRecoveryDao.class);
	@Override
	public UserLoginData getUserLoginData(String cuId) {
		// TODO Auto-generated method stub

		UserLoginData loginData =null;
		String email = null;
		Connection con =null;
		try {
			DBManager db = DBManager.getMyDBManagerObject();			


			con = db.getConnection();
			logger.info(new Date());


			String query = "SELECT * FROM UserLoginData where cuId =?";


			PreparedStatement prs;

			prs = con.prepareStatement(query);
			logger.info("fetching user with cuID:"+ cuId);
			prs.setString(1, cuId);

			logger.info("executing query for password retrieval!!!!");
			ResultSet rs = prs.executeQuery();
			logger.info("executed query for password retrieval!!!!");
			
			String query2 = "SELECT * FROM UserPersonalDetails where cuId = ?";
			PreparedStatement prs1;
			prs1 = con.prepareStatement(query2);
			prs1.setString(1,cuId);
			ResultSet rs1 = prs1.executeQuery();
			if(rs1.next())
			{
				email = rs1.getString("EmailId");
			}
			
			
			
			
			
			
			if(rs.next())
			{
				System.out.println("==========started fetching user details==========");
				loginData = new UserLoginData();
				loginData.setUsername(rs.getString("cuId"));
				loginData.setPassword(rs.getString("Password"));
				loginData.setStatus(rs.getInt("Status"));
				loginData.setGroup(rs.getString("Groupname")+','+ email);
				logger.info("user details fetched");

			}

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
