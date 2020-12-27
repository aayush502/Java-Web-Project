package com.aayush.Test.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aayush.Test.basic.SignUpController;
import com.aayush.Test.database.Database;


public class MemberImpl {
	PreparedStatement ps=null;
	public void saveMemberInfo(MemberVar memberVar) {
		String sql="insert into memberlist(firstname,lastname,email,password)values(?,?,?,?)";
		
		try {
			ps=Database.getConnection().prepareStatement(sql);
			ps.setString(1, memberVar.getFirstname());
			ps.setString(2, memberVar.getLastname());
			ps.setString(3, memberVar.getEmail());
			ps.setString(4, memberVar.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public boolean checkUser(MemberVar memberVar) {
		boolean isLogin=false;
		String sql="select email,password from memberlist where email=? and password=?";
		try {
			ps=Database.getConnection().prepareStatement(sql);
			ps.setString(1, memberVar.getEmail());
			ps.setString(2, memberVar.getPassword());
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				isLogin=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isLogin;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}

