package com.smart.Repositry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConfig {
	protected Connection conn;
	protected ResultSet rs;
	protected PreparedStatement pst;

	DBConfig() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcomplaint", "root", "Pass@12345");

		} catch (Exception ex) {
			System.out.println("problem to connect database: " + ex);
		}
	}
}
