package Dto;

public class CriminalArrestedDto {
	private String name;
	private int age;
	private String gender;
	private String mark;
	private String address;
	private String policeStationname;
	
	public CriminalArrestedDto() {
		
	}
	@Override
	public String toString() {
		
		return "Criminal Name:- " + name +"\n"+
				"Age:- " + age +"\n"+
				"Gender:- " + gender +"\n"+
				"Identification Mark:- " + mark +"\n"+
				"Address:- " + address +"\n"+
				"P.S Name where Criminal Arrested:- " + policeStationname +"\n\n";
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
	public String getPoliceStationname() {
		return policeStationname;
	}
	public void setPoliceStationname(String policeStationname) {
		this.policeStationname = policeStationname;
	}
	public CriminalArrestedDto(String name, int age, String gender, String mark, String address,
			String policeStationname) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mark = mark;
		this.address = address;
		this.policeStationname = policeStationname;
	}
	
	
}
