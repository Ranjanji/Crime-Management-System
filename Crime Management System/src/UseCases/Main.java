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

			System.out.println("Enter Date of Crime");
			String dateofcrime=sc.next();
			System.out.println("Enter Crime Descriptions (Theft/Murder/Robbery/Extortion etc)");
			String description=sc.next();
			System.out.println("Enter Police Station id");
			int psId=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Detail Description of Crime");
			String detailDescription=sc.nextLine();
			System.out.println("Enter Status of Crime");
			String status=sc.next();
			
			String result=null;
			try {
				 result=dao.registerCrime(dateofcrime,description,psId,
					   detailDescription,status);	
			    }
			catch (CrimeExceptions e) {
				System.out.println(e.getMessage());				
			}
			System.out.println(result);
			break;
		case 2:
			try {
				List<Crime> crimes =  dao.getAllCrimes();
				System.out.println("\t\t\t\tCrime List");
				crimes.forEach(c->System.out.println(c));
			    }
			catch (CrimeExceptions e) {
				System.out.println(e.getMessage());	
			}
			break;
		case 3:
			System.out.println("Enter Criminal Name");
			String name=sc.next();
			System.out.println("Enter Criminal's Age");
			int age=sc.nextInt();
			System.out.println("Enter Criminal's Gender");
			String gender=sc.next();
			sc.nextLine();
			System.out.println("Enter Criminal's Address");
			String address=sc.nextLine();
			System.out.println("Enter Police Station's ID (first arrested criminal)");
			int policestationfirstarrestedid=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Criminal's Mark");
			String mark=sc.nextLine();
			String result1=null;

			try {
			     result1=criminalDao.registerCriminal(name,age,gender,address,
							policestationfirstarrestedid,mark);
			} 
			catch (CriminalExceptions e) {
	
			     System.out.println(e.getMessage());
			}
			
			System.out.println(result1);
			break;	
		case 4:

			System.out.println("\nEnter Criminal Id:");
			int crimeNo=sc.nextInt();
			try {
				List<CriminalsCrimeDto> criminals = criminalDao.getCriminalsForCrime(crimeNo);
				System.out.println("=====================");
				System.out.println("# Criminal's Details #");
				System.out.println("=====================");
				criminals.forEach(c->System.out.println(c));
			} 
			catch (CriminalExceptions e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			try {
				int crimeNo1=sc.nextInt();
				List<VictimsDto> victims =  victimDao.getVictimsOfCrime(crimeNo1);
				System.out.println("====================");
				System.out.println("## Victims's List ##");
				System.out.println("====================");
				
				victims.forEach(c->{
					System.out.println("No."+countVictim);
					System.out.println(c);
					countVictim++;
					});
				
			} 
			catch (VictimExceptions e) {
				System.out.println(e.getMessage());
			}
			break;
		case 6:
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
