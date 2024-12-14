package main.java.com.codewithsatyam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.java.com.codewithsatyam.jdbcTest.User;

public class DBUtils {
	private static Connection connection = null;

	public static Connection getConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				return connection;
			}
		} catch (Exception e) {
		}

		try {
			Class.forName(Constants.databaseDriver);
			Connection con = DriverManager.getConnection(Constants.databaseURL, Constants.databaseUser,
					Constants.databasePassword);
			connection = con;
			return con;
		} catch (Exception e) {
			System.out.println(" JDBC connection error: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closePreparedStatement(PreparedStatement pstmt) {
		if (pstmt == null) {
			return;
		}
		try {
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Boolean saveUser(User user) {
		PreparedStatement pstmt = null;
		try {
			pstmt = getConnection().prepareStatement("insert into user(userID, name) values(?,?)");
			pstmt.setInt(1, user.getUserID());
			pstmt.setString(2, user.getName());
			return pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static User getUserByID(int id) {
		PreparedStatement pstmt = null;
		try {
			pstmt = getConnection().prepareStatement("select * from user where userID=?");
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				return new User(id, res.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
