package StudentinsertClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnecttoSql.ConnectionToServer;
import ExceptionClass.StudentException;
import StudentBeem.Student;
import StudentBeem.StudentSignin1;
import StudentImplementation.ImplementStudent;
import ExceptionClass.*;

public class InsertStudentIntoTable implements ImplementStudent{

	@Override
	public String InsertStudent(Student student) throws StudentException {
		String result=null;
	   
	      try (Connection con=new ConnectionToServer().getConnection()){
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1,student.getRoll());
			ps.setString(2,student.getName());
		    ps.setString(3,student.getAddress());
			ps.setString(4,student.getEmail());
			int x=ps.executeUpdate();
			if(x>0)
				result="student details inserted into table";
			else
				result="student details not inserted into table";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new StudentException("student already present in student table");
		
	}
		
		
		return result;
	}

	@Override
	public String StudentSignin(StudentSignin1 s) throws StudentException {
		String result=null;
		Connection con=new ConnectionToServer().getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select *from studentsign where  username=? and password=?");
			
			ps.setString(1,s.getUsername());
		    ps.setString(2,s.getPassword());
		       ResultSet rs=ps.executeQuery();
		      
		       if(rs.next()) {
		    	   result=" signin sucussfull";
		       }
		       if(!rs.next()) {
		    	   
		    	   PreparedStatement ps1=con.prepareStatement("select *from student where roll=?");
		    	   ps1.setInt(1,s.getRoll());
		    	  
		    	   ResultSet rs2=ps1.executeQuery();
		    	   if(!rs2.next()) {
		    		   throw new StudentException ("Entered user id or password not exist plese register first");
		    	   }
		    	   else {
		    		   
		    		   int roll=rs2.getInt("roll");
		    		   String name=rs2.getString("name");
		    		   PreparedStatement ps3=con.prepareStatement("insert into studentsign values(?,?,?,?)");
		    		   ps3.setInt(1, roll);
		    		   ps3.setString(2, name);
		    		   ps3.setString(3,s.getUsername());
		    		   ps3.setString(4,s.getPassword());
		    		   
		    		   int x=ps3.executeUpdate();
		    		   if(x>0)
		    			   result="signin successful by roll and your username="+s.getUsername()+" and password="+s.getPassword();
		    		   else
		    			   result="sigin in not completed";
		    	   }
		    	   System.out.println("End of empty block");
		       }
		    	   
			
			
		} catch (SQLException e) {
		System.out.println(e.getMessage()+"m=edsd");
//			e.printStackTrace();
		}
		
	    	   
		        
		return result;
	}

}
