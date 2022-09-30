package usecases;
import java.util.Scanner;

import bean.Student;
import dao.StudentDao;
import dao.StudentDaoImpl;
import exceptions.StudentException;

public class GetStudentUseCase1 {

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Student Roll:");
		int roll= sc.nextInt();
		
		
		StudentDao dao= new StudentDaoImpl();
		
		try {
		Student student= dao.getStudentByRoll(roll);
		
			System.out.println(student);
		
		}catch (StudentException se) {
			System.out.println(se.getMessage());
		}
		
		
		

	}

}
