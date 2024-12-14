package main.java.com.codewithsatyam.jdbcTest;

import main.java.com.codewithsatyam.utils.DBUtils;
import main.java.com.codewithsatyam.utils.PropertyReader;

public class AppMain {
	public static void main(String[] args) {
	//	DBUtils.saveUser(new User(69, "Satyam Singh"));
		User user = DBUtils.getUserByID(69);
		System.out.println("Received user from DB: " + user.toString());

	}

}
