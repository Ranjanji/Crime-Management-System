package Dao;
import java.util.List;

import Exceptions.CriminalExceptions;
import Bean.Criminal;
import Dto.CriminalArrestedDto;
import Dto.CriminalsCrimeDto;

public interface CriminalDao {
	//Get all Criminals List
	public List<Criminal> getAllCriminals() throws CriminalExceptions;
	
	//Get list of Criminals arrested before
	public List<CriminalArrestedDto> getCriminalsArrestedBefore() throws CriminalExceptions;
	
	//Get list of Criminal's crime
	public List<CriminalsCrimeDto> getCriminalsForCrime(int crimeId) throws CriminalExceptions;
	
	//Resister the crime
	public String registerCriminal(String name,int age,String gender,String address,
			 int policeStationId,String mark) throws CriminalExceptions;
}

