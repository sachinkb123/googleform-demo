package dto;

public class FormDto {
	
	private int formId;
	private String emailId;
	private String name;
	private String phoneNumber;
	private String address;
	private String dateOfBirth;
	private String gender;
	private String maritalStatus;
	private String nationality;
	
	public int getId() {
		return formId;
	}
	public void setId(int formId) {
		this.formId = formId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Override
	public String toString() {
		return "FormDto [id=" + formId + ", emailId=" + emailId + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", maritalStatus="
				+ maritalStatus + ", nationality=" + nationality + "]";
	}

}
