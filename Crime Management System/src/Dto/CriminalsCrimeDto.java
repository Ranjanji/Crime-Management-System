package Dto;

public class CriminalsCrimeDto {
	private String criminalName;
	private int age;
	private String gender;
	private String mark;
	private String address;
	private String description;
	
	@Override
	public String toString() {
		
		return "Criminal Name:- " + criminalName +"\n"+
				"Age:- " + age +"\n"+
				"Gender:- " + gender +"\n"+
				"Identification Mark:- " + mark +"\n"+
				"Address:- " + address +"\n"+
				"Description of Crime:- " + description +"\n";
	}

	public String getCriminalName() {
		return criminalName;
	}

	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CriminalsCrimeDto() {
		
	}
	
	public CriminalsCrimeDto(String criminalName, int age, String gender, String mark, String address,
			String description) {
		super();
		this.criminalName = criminalName;
		this.age = age;
		this.gender = gender;
		this.mark = mark;
		this.address = address;
		this.description = description;
	}
	
	
	
}
