package com.DataDisplay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateEmpInfo {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Update Employee Info");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "Pass@12345");
			PreparedStatement pstm = con
					.prepareStatement("Update Emp Set  name = ?, email = ?, salary = ?, contact = ? where id = ?");
			System.out.print("Enter the Name: ");
			String name = sc.next();
			System.out.print("Enter the Email: ");
			String email = sc.next();
			System.out.print("Enter the salary: ");
			int salary = sc.nextInt();
			System.out.print("Enter the Employee Contact: ");
			int contact = sc.nextInt();
			System.out.println("Enter the Employee id: ");
			int id = sc.nextInt();
			pstm.setString(1, name);
			pstm.setString(2, email);
			pstm.setInt(3, salary);
			pstm.setInt(4, contact);
			pstm.setInt(5, id);
			int result = pstm.executeUpdate();
			if (result > 0) {
				System.out.println("Data Updated");
			} else {
				System.out.println("Problem to insert");
			}
		} catch (Exception ex) {
			System.out.println("Problem :" + ex);
		}
	}

}
