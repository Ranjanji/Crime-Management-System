package Dto;

public class VictimsDto {
	private String name;
	private int age;
	private String gender;
	private String address;
	private String description;
	
	public VictimsDto() {
		
	}

	public VictimsDto(String name, int age, String gender, String address, String description) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "VictimsOfCrimeDTO [name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", description=" + description + "]";
	}
}
