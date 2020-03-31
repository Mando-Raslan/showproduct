package mohamed;

public class User {
	
	private int id , phone;
	private String  email ,password ,address , Country , state , Gender , Base64,AdminorUser;
	private byte []  photo;
	public int getId() {
		return id;
	}
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setId(int id) {
		this.id = id;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getBase64() {
		return Base64;
	}
	public void setBase64(String base64) {
		Base64 = base64;
	}
	public String getAdminorUser() {
		return AdminorUser;
	}
	public void setAdminorUser(String adminorUser) {
		AdminorUser = adminorUser;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	
	

}
