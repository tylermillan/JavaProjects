
public class PBentries {
	private String _phoneNumber;
	private String _lastName;
	private String _firstName;
	
	public PBentries(String phoneNumber, String lastName, String firstName) {
		_phoneNumber = phoneNumber;
		_lastName = lastName;
		_firstName = firstName;
	}
	public String getentry() {
		return (_phoneNumber+" "+_lastName+", "+_firstName);
	}
	public String getphoneNumber() {
		return _phoneNumber; 
	}
	public String getlastName(){
		return _lastName;
	}
	public String getfirstName(){
		return _firstName;
	}
	
}

