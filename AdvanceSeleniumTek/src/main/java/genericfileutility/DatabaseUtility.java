package genericfileutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class DatabaseUtility {
	Connection conn;
	public void getDbConnection(String url, String uname,String pwd) throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
	Connection conn=	DriverManager.getConnection(url, uname, pwd);
	}
catch(Exception e) {}
}
	
	public void closeDBConnection() throws SQLException {
		conn.close();
	}
	
	public ResultSet executeNonSelectQuery(String Query) throws SQLException {

	ResultSet set=null;
		try {
		Statement st=conn.createStatement();
		ResultSet set1=st.executeQuery(Query);
		return set;
	}catch(Exception e) {
		}
		return set;
	}
		
		
		/*public int executeSelectQuery(String Query) {
		
			try {
			Statement st=conn.createStatement();
		  int set=st.executeUpdate(Query);
			}catch(Exception e) {
			}
			return set;
		}*/

		public void getDbConnection()throws SQLException {
			try
			{
				Driver driver =new Driver();
				DriverManager.registerDriver(driver);
				conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects\",\"root@%\",\"root");
				
			}catch(Exception e) {}
		}	
			
		
}
