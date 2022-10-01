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
}

