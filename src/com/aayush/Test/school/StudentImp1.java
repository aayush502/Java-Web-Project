package com.aayush.Test.school;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aayush.Test.database.Database;

public class StudentImp1 implements Student {
	PreparedStatement ps = null;

	@Override
	public void saveStudentInfo(StudentVar studentVar) {//public void save(String name)
		String sql="insert into studentlist(name,grade,roll,gender)values(?,?,?,?)";
		
		try {
			ps = Database.getConnection().prepareStatement(sql);
			ps.setString(1, studentVar.getName());
			ps.setString(2, studentVar.getGrade());
			ps.setInt(3, studentVar.getRoll());
			ps.setString(4, studentVar.getGender());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<StudentVar> getStudentInfo() {
		ArrayList<StudentVar> studentList=new ArrayList<StudentVar>();
		String sql="select * from studentlist";
		try {
			ps=Database.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				StudentVar studentVar=new StudentVar();
				studentVar.setId(rs.getInt("id"));
				studentVar.setName(rs.getString("name"));
				studentVar.setGrade(rs.getString("grade"));
				studentVar.setRoll(rs.getInt("roll"));
				studentVar.setGender(rs.getString("gender"));
				studentList.add(studentVar);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public void deleteStudentInfo(int id) {
		// TODO Auto-generated method stub
		String sql="delete from studentlist where id=?";
		try {
			ps=Database.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	@Override
	public StudentVar getAllStudentInfo(int id) {
		String sql="select * from studentlist where id=?";
		StudentVar studentVar = new StudentVar();
		try {
			ps=Database.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				studentVar.setId(rs.getInt("id"));
				studentVar.setName(rs.getString("name"));
				studentVar.setGrade(rs.getString("grade"));
				studentVar.setRoll(rs.getInt("roll"));
				studentVar.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentVar;
		
	}

	@Override
	public void updateStudentInfo(StudentVar studentVar) {
		String sql="update studentlist set name=?,grade=?,roll=?,gender=? where id=?";
		try {
			ps=Database.getConnection().prepareStatement(sql);
			ps.setString(1, studentVar.getName());
			ps.setString(2, studentVar.getGrade());
			ps.setInt(3, studentVar.getRoll());
			ps.setString(4, studentVar.getGender());
			ps.setInt(5, studentVar.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
