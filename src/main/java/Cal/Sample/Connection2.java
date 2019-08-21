package Cal.Sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.testng.Reporter;

public class Connection2 {
	Scanner sc = new Scanner(System.in);
	public Connection con;

	public void connection1() throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl = "jdbc:sqlserver://ATMECSINLT-085\\SQLEXPRESS;database=Book;integratedSecurity=true;";
		con = (Connection) DriverManager.getConnection(connectionUrl);
		System.out.println("Connected");

	}

	public void select() throws SQLException {
		try {
			Statement state = null;
			state = con.createStatement();
			String st = "Select * from Author";
			ResultSet rs;
			rs = state.executeQuery(st);
			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getInt(4));
			}
			System.out.println("\n\n\n");
			state.close();
		} catch (SQLException e) {
			System.out.println();
		}
	}

	public void Insert() throws SQLException {
		try {
			Statement state = con.createStatement();
			String st = "INSERT INTO Author" + " VALUES('ranjitha',1997,2019)";
			state.executeQuery(st);
			String st1 = "Select * from Author";
			ResultSet rs;
			rs = state.executeQuery(st1);
			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getInt(4));
			}
			state.close();
		} catch (SQLException e) {
			System.out.println();
		}
	}

	public void Deleting() throws SQLException {
		try {
			Statement state;
			System.out.println("enter id to delete");
			int a = sc.nextInt();
			String st = "DELETE FROM [dbo].[Author]" + " WHERE Id=" + a + "";
			state = con.createStatement();
			state.executeQuery(st);
			String st1 = "Select * from Author";
			ResultSet rs;
			rs = state.executeQuery(st1);
			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getInt(4));
			}
			state.close();

		} catch (SQLException e) {
			System.out.println();
		}

	}

	public void Update() throws SQLException {
		try {
			Statement state;
			System.out.println("enter id to update");
			int a = sc.nextInt();
			String st = "UPDATE [dbo].[Author] SET [Name] ='indhira' WHERE Id=" + a + "";
			state = con.createStatement();
			state.executeQuery(st);
			String st1 = "Select * from Author";
			ResultSet rs;
			rs = state.executeQuery(st1);
			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getInt(4));
			}
			state.close();

		} catch (SQLException e) {
			System.out.println();
		}

	}

	public void close1() throws SQLException {
		if (con != null) {
			con.close();
			System.out.println("successfull closed");
		}

		Reporter.log("closed");
	}

}
