package Dao;

import java.util.List;

import Dto.VictimsDto;
import Exceptions.VictimExceptions;

public interface VictimDao {
	//Get list of Victims
	public List<VictimsDto> getVictimsOfCrime(int crimeId) throws VictimExceptions;
}