package Dto;

import java.sql.Date;

public class CrimesDoneByCriminalDto {
	private Date dateOfCrime;
	private String criminalName;
	private String description;
	private String detailDescription;
	
	public CrimesDoneByCriminalDto() {
		
	}
	public CrimesDoneByCriminalDto(Date dateOfCrime, String criminalName, String description,
			String detailDescription) {
		super();
		this.dateOfCrime = dateOfCrime;
		this.criminalName = criminalName;
		this.description = description;
		this.detailDescription = detailDescription;
	}

	@Override
	public String toString() {
		return "CrimesDoneByCriminal"+"\n"+"====================================="
	+"\n"+"Criminal Name:- " + criminalName+"\n"+"Date Of Crime:- " + dateOfCrime +"\n"+ 
	"Criminal description:- " + description +"\n"+ "Criminal detailDescription:- " + detailDescription+"\n";
	}
	
	public Date getDateOfCrime() {
		return dateOfCrime;
	}

	public void setDateOfCrime(Date dateOfCrime) {
		this.dateOfCrime = dateOfCrime;
	}

	public String getCriminalName() {
		return criminalName;
	}

	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	

	
}
