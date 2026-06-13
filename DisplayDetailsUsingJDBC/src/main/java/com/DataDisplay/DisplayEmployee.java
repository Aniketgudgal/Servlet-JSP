package com.DataDisplay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayEmployee {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "Pass@12345");
			PreparedStatement stmp = con.prepareStatement("Select * from Emp");
			ResultSet rs = stmp.executeQuery();
			System.out.println("Employee Information");
			System.out.println("Id \tName \tEmail \t\t\tSalary\tContact");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t  "
						+ rs.getInt(4) + "\t" + rs.getInt(5));
			}

		} catch (Exception ex) {
			System.out.println("Problem: " + ex);
		}
	}

}
