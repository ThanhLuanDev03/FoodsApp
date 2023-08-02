package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class XJdbc {
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	private static String dburl = "jdbc:sqlserver://localhost;database=FoodsApp;encrypt=true;trustServerCertificate=true;";

	private static String username = "sa";

	private static String password = "songlong";

	public static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName(driver);
			c = DriverManager.getConnection(dburl, username, password);
			System.out.println("connection to db");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
