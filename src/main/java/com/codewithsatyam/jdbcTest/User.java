package main.java.com.codewithsatyam.jdbcTest;

public class User {
	private int userID;
	private String name;
	public User(int userID, String name) {
		super();
		this.userID = userID;
		this.name = name;
	}
	
	
	public int getUserID() {
		return userID;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + "]";
	}
	
}
