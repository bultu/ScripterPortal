package com.centurylink.bot.db;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;


import com.centurylink.bot.util.PropertyReader;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBManager {
	
	private static DBManager ref = null;
	String dbUrl ,username ,password ,dbClass;
	private static ComboPooledDataSource cpds =new ComboPooledDataSource();
	
	private DBManager()
	{
		PropertyReader  reader = PropertyReader .getMyResourceReaderObject();
		
		try
		{
			cpds.setDriverClass(reader.getProperties().getProperty("database.dbClass"));
			cpds.setUser(reader.getProperties().getProperty("database.username"));
			cpds.setPassword(reader.getProperties().getProperty("database.password"));
			cpds.setJdbcUrl(reader.getProperties().getProperty("database.url"));
			cpds.setAutomaticTestTable(reader.getProperties().getProperty("database.automaticTestTable"));
			cpds.setInitialPoolSize(Integer.parseInt(reader.getProperties().getProperty("database.initialPoolSize")));
			cpds.setMaxConnectionAge(Integer.parseInt(reader.getProperties().getProperty("databse.maxConnectionAge")));
			cpds.setMaxIdleTime(Integer.parseInt(reader.getProperties().getProperty("database.maxIdleTime")));
			cpds.setMaxPoolSize(Integer.parseInt(reader.getProperties().getProperty("database.maxPoolSize")));
			cpds.setMinPoolSize(Integer.parseInt(reader.getProperties().getProperty("database.minPoolSize")));
			cpds.setAcquireIncrement(Integer.parseInt(reader.getProperties().getProperty("database.acquireIncrement")));
			cpds.setTestConnectionOnCheckout(Boolean.parseBoolean(reader.getProperties().getProperty("database.testConnectionOncheckout")));
			
		}
		catch(PropertyVetoException e)
		{
			e.printStackTrace();
		}

	}
	
	public static DBManager getMyDBManagerObject()
	{
		if(ref == null)
			ref = new DBManager();
		return ref;
		
	}
	
	public Connection getConnection()
	{
		
		
		Connection con =null;
		try {
			con = cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection established");
		
		return con;
	
	}

}
