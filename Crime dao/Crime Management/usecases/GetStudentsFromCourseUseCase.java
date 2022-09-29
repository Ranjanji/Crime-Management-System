package usecases;
import java.util.List;
import java.util.Scanner;

import bean.StudentDTO;
import dao.StudentDao;
import dao.StudentDaoImpl;

public class GetStudentsFromCourseUseCase {

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the Course Name");
		
		String cname= sc.next();

		
		StudentDao dao = new StudentDaoImpl();
		
		try {
		List<StudentDTO> dtos= dao.getAllStudentsByCname(cname);
		
		dtos.forEach(dto -> System.out.println(dto));
		
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
