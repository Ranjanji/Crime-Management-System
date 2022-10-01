package UseCases;
import java.util.List;

import Exceptions.CrimeExceptions;
import Exceptions.CriminalExceptions;
import Exceptions.VictimExceptions;
import Bean.Crime;
import Bean.Criminal;

import Dao.CrimeDaoImp;
import Dao.Crimedao;
import Dao.CriminalDao;
import Dao.CriminalDaoImp;
import Dao.VictimDao;
import Dao.VictimDaoImp;

import Dto.CrimesDoneByCriminalDto;
import Dto.CriminalsCrimeDto;
import Dto.VictimsDto;
import Exceptions.CriminalExceptions;

public class Main {

	public static void main(String[] args) {
	
		Crimedao dao = new CrimeDaoImp();
		try {
			List<CrimesDoneByCriminalDto> crimes =  dao.getCrimesOfACriminal(2);
			System.out.println(crimes);
		} catch (CrimeExceptions e) {
			
			e.printStackTrace();
		}
		CriminalDao criminalDao = new CriminalDaoImp();
		try {
			List<CriminalsCrimeDto> criminals = criminalDao.getCriminalsForCrime(2);
			System.out.println(criminals);
		} catch (CriminalExceptions e) {
			
			System.out.println(e.getMessage());
		}
		VictimDao victimDao =  new VictimDaoImp();
		try {
			List<VictimsDto> victims =  victimDao.getVictimsOfCrime(2);
			System.out.println(victims);
		} catch (VictimExceptions e) {
			
			e.printStackTrace();
		}
	}

}
