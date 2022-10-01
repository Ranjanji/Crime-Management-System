package UseCases;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

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
	public static int countCrime=1;
	public static int countStatus=0;
	public static int countCriminal=1;
	public static int countVictim=1;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("🕵️‍♀️🕵️‍♀️🕵️‍♀️ Crime Information Management System 🕵️‍♀️🕵️‍♀️🕵️‍♀️"+"\n");
		while(true) {
			
			System.out.println();
			System.out.println("Press 1 for Register Crime");
			System.out.println("Press 2 for Crime Detailed List");
			System.out.println("Press 3 for Register Criminal");
			System.out.println("Press 4 for Criminal's Details");
			System.out.println("Press 5 for Victim's Details");
			System.out.println("Press 6 for Status of Crime");
			System.out.println("Press 7 for Exit the System...");
			
			int x=sc.nextInt();
			Crimedao dao = new CrimeDaoImp();
			CriminalDao criminalDao = new CriminalDaoImp();
			VictimDao victimDao =  new VictimDaoImp();
		switch(x) {	
		case 1:
//			Crimedao dao = new CrimeDaoImp();
			System.out.println("Enter Date of Crime");
			String dateofcrime=sc.next();
			System.out.println("Enter Crime Descriptions (Theft/Murder/Robbery/Extortion etc)");
			String description=sc.next();
			System.out.println("Enter Police Station id");
			int psId=sc.nextInt();
			System.out.println("Enter Detail Description of Crime");
			String detailDescription=sc.next();
			System.out.println("Enter Status of Crime");
			String status=sc.next();
			String result=null;
			try {
				 result=dao.registerCrime(dateofcrime,description,psId,
					   detailDescription,status);
				
			}
			catch (CrimeExceptions e) {
				//			e.printStackTrace();
				System.out.println(e.getMessage());
							
			}
			System.out.println(result);
			break;
		case 2:
//			Crimedao dao = new CrimeDaoImp();
				try {
					List<CrimesDoneByCriminalDto> crimes =  dao.getCrimesOfACriminal(11);
					crimes.forEach(c->System.out.println(c));
		//			System.out.println(crimes);
				} catch (CrimeExceptions e) {
		//			e.printStackTrace();
					System.out.println(e.getMessage());
					
				}
				break;
		case 3:
//			CriminalDao criminalDao = new CriminalDaoImp();
			System.out.println("Enter Criminal Name");
			String name=sc.next();
			System.out.println("Enter Criminal's Age");
			int age=sc.nextInt();
			System.out.println("Enter Criminal's Gender");
			String gender=sc.next();
			System.out.println("Enter Criminal's Address");
			String address=sc.next();
			System.out.println("Enter Police Station id");
			int policeStationId=sc.nextInt();
			System.out.println("Enter Police Station's ID (first arrested criminal)");
			int policestationfirstarrestedid=sc.nextInt();
			System.out.println("Enter Identification Mark of Criminal");
			String mark=sc.next();
			String result1=null;

				 try {
					result1=criminalDao.registerCriminal(name,age,gender,address,policeStationId,
								policestationfirstarrestedid, mark);
				} catch (CriminalExceptions e) {
					
//					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			
			System.out.println(result1);
			break;	
		case 4:
//			CriminalDao criminalDao = new CriminalDaoImp();
			try {
				List<CriminalsCrimeDto> criminals = criminalDao.getCriminalsForCrime(101);
				System.out.println("=====================");
				System.out.println("# Criminal's Details #");
				System.out.println("=====================");
				criminals.forEach(c->System.out.println(c));
				
//				System.out.println(criminals);
			} catch (CriminalExceptions e) {
//				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			break;
		case 5:
//			VictimDao victimDao =  new VictimDaoImp();
			try {
				List<VictimsDto> victims =  victimDao.getVictimsOfCrime(102);
				System.out.println("====================");
				System.out.println("## Victims's List ##");
				System.out.println("====================");
				
				victims.forEach(c->{
					System.out.println("No."+countVictim);
					System.out.println(c);
					countVictim++;
					});
//				System.out.println(victims);
			} catch (VictimExceptions e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			break;
		case 6:
//			Crimedao dao = new CrimeDaoImp();
		try {
			List<Crime> crimes =  dao.getAllCrimes();
			
			crimes.forEach(c->{
				if(c.getStatus().equals("Not_Solved")) countStatus++;
			});
			System.out.println("###### Crime Status ######");
			System.out.println("Solved     :- "+(crimes.size()-countStatus));
			System.out.println("Not Solved :- "+countStatus);
//			System.out.println(crimes);
		} catch (CrimeExceptions e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		break;
		case 7:
			System.out.println("=*=*=*=*=*=*=Thank_You for CIM System=*=*=*=*=*=*=");
			break;
		}
		if(x==7) break;
	}
		
	}

}
