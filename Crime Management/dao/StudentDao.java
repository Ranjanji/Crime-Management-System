package dao;

import java.util.List;

import bean.Student;
import bean.StudentDTO;
import exceptions.CourseException;
import exceptions.StudentException;

public interface StudentDao {
	
	//4:20 pm
	
	
	public String registerStudent(String name,int marks,String email,String passwrod);

	public String registerStudent2(Student student);
	
	public Student getStudentByRoll(int roll)throws StudentException;

	
	public Student loginStudent(String username, String password)throws StudentException;
	
	
	public List<Student> getAllStudentDetails()throws StudentException;
	
	
	public String registerStudentInsideACourse(int cid, int roll)throws StudentException,CourseException ;
	
	public List<StudentDTO> getAllStudentsByCname(String cname)throws CourseException;
	
	
	
}
