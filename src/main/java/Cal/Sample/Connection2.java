package Cal.Sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.testng.Reporter;
import org.testng.annotations.Listeners;

@Listeners
public class Connection2 {
	Scanner sc = new Scanner(System.in);
	public Connection con;
	public ResultSet rs;
	String str;

	public Connection connection1() throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl = "jdbc:sqlserver://ATMECSINLT-085\\SQLEXPRESS;database=Book;integratedSecurity=true;";
		con = DriverManager.getConnection(connectionUrl);
		return con;
	}

	public String select(int a) throws SQLException {
		try {
			Statement state = null;
			state = con.createStatement();
			String st = "Select * from Author  where Id=" + a + "";
			rs = state.executeQuery(st);

			while (rs.next()) {
				str = rs.getInt(1) + "" + rs.getString(2) + "" + rs.getInt(3) + "" + rs.getInt(4);
			}
			state.close();

		} catch (SQLException e) {
			System.out.println();
		}
		return str;
	}

	public void Insert(String name, int b, int d) throws SQLException {
		Statement state = con.createStatement();
		String st = "INSERT INTO Author" + " VALUES(" + "'" + name + "'" + "," + b + "," + d + ")";
		state.execute(st);
		String st1 = "Select * from Author ";
		rs = state.executeQuery(st1);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getInt(4));
		}
		System.out.println("\n\n");

		state.close();
	}

	public void Deleting(int a) throws SQLException {
		Statement state;
		String st = "DELETE FROM [dbo].[Author] WHERE Id=" + a + "";
		state = con.createStatement();
		state.execute(st);
		String st2 = "Select * from Author ";
		rs = state.executeQuery(st2);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getInt(4));
		}
		System.out.println("\n\n");
		state.close();
	}

	public void Update(int a, String name) throws SQLException {
		Statement state;
		String st = "UPDATE [dbo].[Author] SET [Name]=" + "'" + name + "'" + " WHERE Id=" + a + "";
		state = con.createStatement();
		state.execute(st);
		String st3 = "Select * from Author ";
		rs = state.executeQuery(st3);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getInt(4));
		}
		System.out.println("\n\n");
		state.close();

	}

	public void close1() throws SQLException {
		if (con != null) {
			con.close();

			System.out.println("successfull closed");
		}

		Reporter.log("closed");
	}

}
