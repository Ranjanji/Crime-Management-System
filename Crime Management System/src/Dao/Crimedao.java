package Dao;
import java.sql.Date;
import java.util.List;


import Bean.Crime;
import Dto.CrimesDoneByCriminalDto;
import Exceptions.CrimeExceptions;
import Dto.CriminalsCrimeDto;

public interface Crimedao {
	//Resister the crime
	public String registerCrime(String dateofcrime,String description,int policeStationId,
		   String detailDescription,String status) throws CrimeExceptions;

	//Get all Crime List
    public List<Crime> getAllCrimes() throws CrimeExceptions;

    //Get List of Crimes of Criminal list
	public List<CrimesDoneByCriminalDto> getCrimesOfACriminal(int criminalId) throws CrimeExceptions;
}
