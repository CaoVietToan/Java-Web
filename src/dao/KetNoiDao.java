package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiDao {
	public static Connection connection;

	public void getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://CALLMECHEI:1433;databaseName=BanGiay;";
			String user = "sa";
			String password = "200401";
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(">>Connect Error!");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		KetNoiDao kn = new KetNoiDao();
		kn.getConnection();
	}
}
