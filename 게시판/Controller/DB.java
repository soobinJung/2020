package test;

import java.sql.*;

public class DB {

	public static Connection getConnection() {
		Connection con = null;
		try {
			String url = "jdbc:postgresql://127.0.0.1:9888/postgres";
			String usr = "postgres";
			String pwd = "1234";
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usr, pwd);
		} catch (Exception ex) {
			System.out.println("Error name :" + ex);
		}
		return con;

	}
}
