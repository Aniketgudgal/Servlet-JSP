package com.user.Repositry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConfig {

	protected Connection con;
	protected ResultSet rs;
	protected PreparedStatement pst;

	public DBConfig() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "Pass@12345");
		} catch (Exception ex) {
			System.out.println("Problem in DbConfig");
		}
	}
}
