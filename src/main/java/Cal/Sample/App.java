package Cal.Sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Listeners;

/**
 * Hello world!
 *
 */
@Listeners
public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection con;
		ResultSet rs;
		Connection2 con2 = new Connection2();
		con = con2.connection1();
		// con2.Insert("indhira", 1383, 1222);
		// con2.Deleting(28);
		// con2.Update(38, "saurabh");
		String str1 = con2.select(27);
		System.out.println(str1);
		con2.close1();
	}

}
