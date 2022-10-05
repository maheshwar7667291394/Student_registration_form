package StudentBeem;

public class StudentSignin1 {
	private int roll;
	private String username;
	private String password;
	public StudentSignin1(int roll, String username, String password) {
		super();
		this.roll = roll;
		this.username = username;
		this.password = password;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "StudentSignin1 [roll=" + roll + ", username=" + username + ", password=" + password + "]";
	}
	
	

	
	

}
