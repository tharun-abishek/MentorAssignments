package org.mysql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDetails {

	Scanner ip = new Scanner(System.in);

	void getOption() {
		int condition = 0;
		do {
			System.out.println("Enter your Choice");
			System.out.println("1.Register Student Details");
			System.out.println("2.View Student Details");

			int choice = ip.nextInt();
			switch (choice) {
			case 1:
				insertStudentInfo();
				break;
			case 2:
				viewStudentInfo();
				break;

			default:
				System.out.println("Enter Correct Choice");
			}
			System.out.println("Press 1 to continue..");
			condition = ip.nextInt();
		} while (condition == 1);
	}

	void insertStudentInfo() {
		try {
			String url = "jdbc:mysql://localhost:3306/student";
			String username = "root";
			String pass = "password199";
			Connection con = DriverManager.getConnection(url, username, pass);
			int rollno, age;
			String ph;
			String name, gender, mailid;
			System.out.println("Enter RollNumber");
			rollno = ip.nextInt();
			ip.nextLine();
			System.out.println("Enter Name");
			name = ip.nextLine();
			System.out.println("Enter Age");
			age = ip.nextInt();
			ip.nextLine();
			System.out.println("Enter Gender:");
			gender = ip.nextLine();
			System.out.println("Enter EmailId");
			mailid = ip.nextLine();
			System.out.println("Enter Phonenumber");
			ph = ip.nextLine();
			String query = "insert into StudentInfo values(?,?,?,?,?,?)";
			PreparedStatement smt = con.prepareStatement(query);
			smt.setInt(1, rollno);
			smt.setString(2, name);
			smt.setInt(3, age);
			smt.setString(4, gender);
			smt.setString(5, mailid);
			smt.setString(6, ph);
			smt.executeUpdate();
			System.out.println("Inserted Successfully");

			smt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Please check your input");
		}
	}

	void viewStudentInfo() {
		try {
			String url = "jdbc:mysql://localhost:3306/student";
			String username = "root";
			String pwd = "password199";
			Connection con = DriverManager.getConnection(url, username, pwd);
			Statement smt = con.createStatement();
			String query = "select * from StudentInfo";
			ResultSet rs = smt.executeQuery(query);
			while (rs.next()) {
				int rollno = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String gender = rs.getString(4);
				String mailid = rs.getString(5);
				String ph = rs.getString(6);
				System.out.println(rollno + "\t" + name + "\t" + age + "\t" + gender + "\t" + mailid + "\t" + ph);
			}
			rs.close();
			smt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		StudentDetails sm = new StudentDetails();
		sm.getOption();
	}
}
