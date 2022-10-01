package Dao;
import java.util.List;

import Exceptions.CriminalExceptions;
import Bean.Criminal;
import Dto.CriminalArrestedDto;
import Dto.CriminalsCrimeDto;

public interface CriminalDao {
	public List<Criminal> getAllCriminals() throws CriminalExceptions;
	public List<CriminalArrestedDto> getCriminalsArrestedBefore() throws CriminalExceptions;
	public List<CriminalsCrimeDto> getCriminalsForCrime(int crimeId) throws CriminalExceptions;
	public String registerCriminal(String name,int age,String gender,String address,int policeStationId,
			int policestationfirstarrestedid,String mark) throws CriminalExceptions;
}

