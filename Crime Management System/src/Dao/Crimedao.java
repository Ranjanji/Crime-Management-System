package Dao;
import java.sql.Date;
import java.util.List;


import Bean.Crime;
import Dto.CrimesDoneByCriminalDto;
import Exceptions.CrimeExceptions;
import Dto.CriminalsCrimeDto;

public interface Crimedao {
	public String registerCrime(String dateofcrime,String description,int policeStationId,
		   String detailDescription,String status) throws CrimeExceptions;
	
    public List<Crime> getAllCrimes() throws CrimeExceptions;
	public List<CrimesDoneByCriminalDto> getCrimesOfACriminal(int criminalId) throws CrimeExceptions;
}
