package usecases;
import java.util.Scanner;

import dao.StudentDao;
import dao.StudentDaoImpl;

public class AllocateStudentToCourse {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the cid");
		int cid= sc.nextInt();

		System.out.println("Enter the roll");
		int roll= sc.nextInt();
		
		//5:25
		
		
		StudentDao dao = new StudentDaoImpl();
		
		try {
		String result = dao.registerStudentInsideACourse(cid, roll);
		
		System.out.println(result);
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
	}

}
