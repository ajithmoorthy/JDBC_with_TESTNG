package Cal.Sample;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class test1 {
	Connection con;

	AppTest app = new AppTest();

	@BeforeTest
	void testingconnection() throws ClassNotFoundException, SQLException {
		con = app.connection1();
		Assert.assertNotNull(con, "not connected");
		System.out.println("Connection Estabilished");
	}

	@Test
	void select1() throws SQLException {
		String rs = app.select(27);
		String arjun1 = "38saurabh19882040";
		String arjun = "27arjun19972019";
		Assert.assertEquals(rs, arjun);
		// SoftAssert soft = new SoftAssert();
		// soft.assertEquals(rs, arjun1);
		// soft.assertAll();
	}

	@Test
	void insert() throws SQLException {
		app.Insert("ajith", 123, 123);
		String rs = app.select(63);
		Assert.assertEquals(rs, "63ajith123123");
		System.out.println("successfully inserted");
	}

	@Test
	void update() throws SQLException {
		app.Update(63, "vinoth");
		String rs = app.select(63);
		Assert.assertEquals(rs, "63vinoth123123");
		System.out.println("successfully inserted");

	}

	@Test(priority = 0)
	void delete() throws SQLException {
		app.Deleting(62);
		String rs = app.select(62);
		Assert.assertEquals(rs, null);
		System.out.println("successfully inserted");

	}

	@AfterTest
	void close2() throws SQLException {
		// app.Update(56, "vinoth");
		// app.Deleting(56);
		app.close1();
		// state.cl;

	}
}
