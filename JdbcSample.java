package org.mysql.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcSample {
	public static void main(String[] args) throws Exception {
		try {
			String url = "jdbc:mysql://localhost:3306/student";
			String username = "root";
			String pass = "password199";
			Connection con = DriverManager.getConnection(url, username, pass);
			System.out.println("Connected Successfully");
			Statement sm = con.createStatement();
			String sql = "create table StudentInfo(RollNo int not null primary key,Name varchar(20),Age int,Gender varchar(20),EmailId varchar(30),PhoneNo varchar(10))";
			sm.executeUpdate(sql);
			System.out.println("Table Created");
			sm.close();
			con.close();
		} catch (Exception ex) {
			System.out.println("Not Connected");
			ex.printStackTrace();
		}
	}
}
