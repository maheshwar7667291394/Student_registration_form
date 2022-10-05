package StudentImplementation;

import ExceptionClass.StudentException;

import StudentBeem.Student;
import StudentBeem.StudentSignin1;


public interface ImplementStudent {
	public String InsertStudent(Student student)throws StudentException;
	
	public String StudentSignin(StudentSignin1 s) throws Exception; 

}
