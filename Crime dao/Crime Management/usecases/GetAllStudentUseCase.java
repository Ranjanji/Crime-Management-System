package usecases;
import java.util.List;

import bean.Student;
import dao.StudentDao;
import dao.StudentDaoImpl;
import exceptions.StudentException;

public class GetAllStudentUseCase {
	
	
	public static void main(String[] args) {
		
		StudentDao dao = new StudentDaoImpl();
		
		try {
		List<Student> students= dao.getAllStudentDetails();
		
		students.forEach(s ->{
			
			System.out.println("Student Name :"+s.getName());
			System.out.println("Student email: "+s.getEmail());
			
			System.out.println("=======================");
		});
		
		
		
		
		}catch(StudentException se) {
			System.out.println(se.getMessage());
		}
		
		
		
		
		
	}

}
