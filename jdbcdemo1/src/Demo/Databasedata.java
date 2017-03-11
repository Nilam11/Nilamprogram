package Demo;
import java.sql.*;
import java.util.Scanner;

import test.Student;
import main.main;


public class Databasedata {
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
	      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
	      return con;
	}
	public void insertdata( Connection con) throws SQLException
	{
		PreparedStatement st=con.prepareStatement("insert into student values(?,?,?)");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter values");
		 int id=sc.nextInt();
		 String name=sc.next();
		 int marks=sc.nextInt();
		 st.setInt(1, id);
		 st.setString(2, name);
		 st.setInt(3,marks);
		 int count=0;
		 if(count>0)
	    	 System.out.println("Record inserted: "+count);
	
	}
	public Student[] retivedata(Connection con ) throws SQLException
	{   Statement st=con.createStatement();
        String str=("select * from student");
	    ResultSet rs=st.executeQuery(str);
	    Student s[]=new Student[50];
	    for(int i=0;rs.next();i++)
	    {
	    	s[i]=new Student();
	    	s[i].setId(rs.getInt(1));
	    	s[i].setName(rs.getString(2));
	    	s[i].setMarks(rs.getInt(3));
	    }
	  return s;
	}
	 public void displayinfo(Student[] s) throws SQLException
	{
		for(Student str:s)
		{
			System.out.println(str.getId()+" ");
			System.out.println(str.getName()+" ");
			System.out.println(str.getMarks());
		}
	}
	      
		
	
	

}
