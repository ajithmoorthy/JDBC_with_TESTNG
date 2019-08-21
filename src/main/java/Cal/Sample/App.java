package Cal.Sample;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection2 con2 = new Connection2();
		con2.connection1();
		con2.select();
		con2.Insert();
		con2.Deleting();
		con2.Update();
		con2.close1();
	}

}
