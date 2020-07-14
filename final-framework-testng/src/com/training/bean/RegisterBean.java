package com.training.bean;

public class RegisterBean {
	
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String passWord;
	private String confirmPassword;
	private String phone;
	private String language;
	private String profile;

	public RegisterBean() {
	}

	public RegisterBean(String firstName, String lastName, String email, String userName, String passWord, String confirmPassword, String phone, String language, String profile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.passWord = passWord;
		this.confirmPassword = confirmPassword;
		this.phone = phone;
		this.language = language;
		this.profile = profile;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "RegisterBean [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", userName=" + userName + ", passWord=" + passWord + ", confirmPassword=" + confirmPassword + ", phone=" + phone + ", language=" + language + ", profile=" + profile + "]";
	}


}
