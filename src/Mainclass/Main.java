package Mainclass;

import java.util.Scanner;

import ExceptionClass.StudentException;
import StudentBeem.Student;
import StudentBeem.StudentSignin1;
import StudentImplementation.ImplementStudent;
import StudentinsertClass.InsertStudentIntoTable;

public class Main {
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("welcome to student course registration form");
		while(true) {

			System.out.println("for student register press 1");
			System.out.println("for login press 2");
			int sc=input.nextInt();
			switch(sc) {
			case 1:
				System.out.println("Enter roll");
				int roll=input.nextInt();
				System.out.println("Enter name");
				String name=input.next();
			
				System.out.println("Enter address");
				String address=input.next();
				System.out.println("Enter email");
				String email=input.next();
				Student student=new Student(roll, name, address, email);
				ImplementStudent simpl=new InsertStudentIntoTable();
				String result;
				try {
					result = simpl.InsertStudent(student);
					System.out.println(result);
				} catch (StudentException e) {
					System.out.println(e.getMessage());

				}
				break;
			case 2:
				System.out.println("Enter roll");
				int roll1=input.nextInt();
				System.out.println("Enter username");
				String username=input.next();
				System.out.println("Enter password");
				String password=input.next();
				
				StudentSignin1 sin=new StudentSignin1(roll1,username, password);
				 ImplementStudent simpl1=new InsertStudentIntoTable();
				 
				 try {
					String result1=simpl1.StudentSignin(sin);
					System.out.println(result1);
				} catch (Exception e) {
					System.out.println(e.getMessage());
//					e.printStackTrace();
				}
				 break;
				 
				
			    default:
				System.out.println("No any operation performed");
			}
			System.out.println("want to perform more operation Enter yes/no");
			String yn=input.next();
			if(yn.equalsIgnoreCase("no"))
				break;
		
			
		}
		
	}

}
