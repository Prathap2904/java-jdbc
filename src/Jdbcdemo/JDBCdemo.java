package Jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCdemo {

	public static void main(String[] args) throws Exception {
		
		update();
	}
	public static void readRecord() throws Exception{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String uname = "root";
		String password = "12345";
		String query = "select * from employee";
		
		Connection con = DriverManager.getConnection(url,uname, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		System.out.println("Emp Id : "+rs.getInt(1));
		System.out.println("Emp Name : "+rs.getString(2));
		System.out.println("Emp Salary : "+rs.getInt(3));
		
		rs.next();
		System.out.println("Emp Name : "+rs.getInt(1));
		System.out.println("Emp Name : "+rs.getString(2));
		System.out.println("Emp Salary : "+rs.getInt(3));
		
		con.close();
	}
	public static void insertRecord()throws Exception{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String uname = "root";
		String password = "12345";
		String query = "insert into employee values(3,'Priya',250000)";
		
		Connection con = DriverManager.getConnection(url,uname, password);
		Statement st = con.createStatement();
		int rows = st.executeUpdate(query);
		
		System.out.println("The number of rows are affected : "+rows);
	
	}
	public static void insertusingprepare()throws Exception{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String username = "root";
		String password = "12345";
		String query = "insert into employee values(?,?,?)";
		
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,5);
		pst.setString(2, "Prathap");
		pst.setInt(3, 12000);
		int rows = pst.executeUpdate();
		
		System.out.println("The affected rows are : "+rows);
	}
	public static void delete()throws Exception{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String username = "root";
		String password = "12345";
		int id = 5;
		String query = "delete from employee where id = "+id;
		
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st = con.createStatement();
		int rows = st.executeUpdate(query);
		
		System.out.println("No of rows affected : "+rows);
		con.close();
	}
	public static void update()throws Exception{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String username = "root";
		String password = "12345";
		String query = "update employee set salary = 15000 where empid=5";
		
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st = con.createStatement();
		int rows = st.executeUpdate(query);
		
		System.out.println("No of rows affected : "+rows);
		
		con.close();
	}
}
