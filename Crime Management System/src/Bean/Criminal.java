package Bean;

public class Criminal {

	private String name;
	private int age;
	private String gender;
	private String mark;
	private String address;
	private int policeStationId;  //Police Station Id where criminal first arrested
	
	public Criminal(){
	}

	public Criminal(String name, int age, String gender, String mark, String address, int policeStationId) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mark = mark;
		this.address = address;
		this.policeStationId = policeStationId;
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

	@Override
	public String toString() {
		return "Criminal [name=" + name + ", age=" + age + ", gender=" + gender + ", mark=" + mark + ", address="
				+ address + ", policeStationId=" + policeStationId + "]";
	}


	
	
	
	
	
}
