package Dao;
import java.util.List;


import Bean.Crime;
import Dto.CrimesDoneByCriminalDto;
import Exceptions.CrimeExceptions;
import Dto.CriminalsCrimeDto;

public interface Crimedao {
public List<Crime> getAllCrimes() throws CrimeExceptions;
	
	public List<CrimesDoneByCriminalDto> getCrimesOfACriminal(int criminalId) throws CrimeExceptions;
}
