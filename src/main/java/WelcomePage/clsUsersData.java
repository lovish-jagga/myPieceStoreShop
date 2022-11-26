package WelcomePage;

public class clsUsersData 
{
	String fullName, email,phoneNumber;
	public clsUsersData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "clsUsersData [fullName=" + fullName + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	public clsUsersData(String fullName, String email, String phoneNumber) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
