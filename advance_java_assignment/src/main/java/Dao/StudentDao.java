package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.DBConnection;
import Model.Student;

public class StudentDao {
	public static void insertStudent(Student s) {
		try {
			Connection connection = DBConnection.createConnection();
			String sql = "insert into student (fname,lname,email,mobile,gender,password) values(?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setLong(4, s.getMobile());
			pst.setString(5, s.getGender());
			pst.setString(6, s.getPassword());
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection connection = DBConnection.createConnection();
			String sql = "select * from student  where email=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	public static Student loginSeller(Student s) {
		Student s1 = null;
		try {
			Connection connection = DBConnection.createConnection();
			String sql = "select * from student  where email=? and password=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, s.getEmail());
			pst.setString(2, s.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				s1 = new Student();
				s1.setId(rs.getInt("id"));
				s1.setFname(rs.getString("fname"));
				s1.setLname(rs.getString("lname"));
				s1.setEmail(rs.getString("email"));
				s1.setMobile(rs.getLong("mobile"));
				s1.setGender(rs.getString("gender"));
				s1.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return s1;
	}
	public static void updateProfile(Student s) {
		try {
			Connection connection = DBConnection.createConnection();
			String sql = "update student set fname=?,lname=?,email=?,mobile=?,gender=? where id=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setLong(4, s.getMobile());
			pst.setString(5, s.getGender());
			pst.setInt(6, s.getId());
			pst.executeUpdate();
			System.out.println("data updated...");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static boolean checkOldPassword(int id,String op) {
		boolean flag = false;
		try {
			Connection connection = DBConnection.createConnection();
			String sql = "select * from student where id=? and password=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, op);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void changePassword(int id,String np) {
		try {
			Connection connection = DBConnection.createConnection();
			String sql="update student set password=? where id=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("password changed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void changeNewPassword(String email,String np) {
		try {
			Connection connection = DBConnection.createConnection();
			String sql="update student set password=? where email=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("password will changed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
