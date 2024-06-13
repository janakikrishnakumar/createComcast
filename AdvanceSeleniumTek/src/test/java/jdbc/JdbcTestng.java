package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JdbcTestng {

	@Test
	public void projectCheck() throws SQLException {
		
		String expectedProject="FB-01";
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);//register the db driver
		//Step2: connect to db
		Connection conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		System.out.println("Connected Successfully");
		boolean flag=false;
		//Step3: Create sql statement
		Statement stat= conn.createStatement();
		
		//Step4:execute select query and give output
		ResultSet set=stat.executeQuery("select * from project");
		while(set.next())
		{
			String actualProject=set.getString(4);
			System.out.println(actualProject);
			if(expectedProject.equals(actualProject)) {
				flag=true;
				System.out.println("expected Project is available");
			}
			
		}
		if(flag==false) {
			System.out.println("expected Project is not availale");
		}
		// step5: close the connection
		conn.close();
 
	}
}
