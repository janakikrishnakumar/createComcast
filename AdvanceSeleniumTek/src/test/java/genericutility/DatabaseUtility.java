package genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {

	 

	Connection con;
	
	public void getDbConnection(String url , String uname, String pwd) {
		try
		{
			Driver driver =new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(url,uname, pwd);
			
		}catch(Exception e) {}
	}		 
	
	public void getDbConnection()throws SQLException {
		try
		{
			Driver driver =new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects\",\"root@%\",\"root");
			
		}catch(Exception e) {}
	}	
	public void closeDbConnection() throws SQLException {
		try {
			con.close();
		}catch(Exception e) {}
	}
	
}
