package com.MVCProject.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConfig {
	protected Connection conn;
	protected PreparedStatement pst;
	protected ResultSet rs;

	public DBConfig() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "Aniket@5867");

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Exception in connection : " + ex);
		}
	}

}
