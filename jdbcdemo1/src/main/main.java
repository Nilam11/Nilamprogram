package main;

import java.sql.Connection;
import java.sql.SQLException;

import Demo.Databasedata;
import test.Student;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try{
			Databasedata db=new Databasedata();
		
			Connection con=	db.getConnection();
			Student stud=new Student();
			db.insertdata(con);
	        db.displayinfo(db.retivedata(con));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
