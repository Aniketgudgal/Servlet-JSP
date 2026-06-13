package com.DataDisplay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertData {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "Pass@12345");
			PreparedStatement pstm = con.prepareStatement("insert into Emp values('0',?,?,?,?)");
			System.out.print("Enter the Name: ");
			String name = sc.next();
			System.out.print("Enter the Email: ");
			String email = sc.next();
			System.out.print("Enter the salary: ");
			int salary = sc.nextInt();
			System.out.print("Enter Contact Number: ");
			int num = sc.nextInt();
			pstm.setString(1, name);
			pstm.setString(2, email);
			pstm.setInt(3, salary);
			pstm.setInt(4, num);
			int result = pstm.executeUpdate();
			if (result > 0) {
				System.out.println("Data Inserted");
			} else {
				System.out.println("Problem to insert");
			}
		} catch (Exception ex) {
			System.out.println("Problem :" + ex);
		}
	}

}
