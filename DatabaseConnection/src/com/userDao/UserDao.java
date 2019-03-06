package com.userDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.getDatabase.GetConnection;

public class UserDao {

	public boolean validateUser(String uName, String pass) 
	{
		String sql = "select * from user where uname = ? and pass = ?";
		GetConnection gc = new GetConnection();
		PreparedStatement ps = null;
		try {
			gc.ps = GetConnection.getMySqlConnection().prepareStatement(sql);
			gc.ps.setString(1, uName);
		    gc.ps.setString(2, pass);
		    gc.rs = gc.ps.executeQuery();
		
		if(gc.rs.next()) {
			return gc.rs.next();
		}
		}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return false;
		
	}
}
