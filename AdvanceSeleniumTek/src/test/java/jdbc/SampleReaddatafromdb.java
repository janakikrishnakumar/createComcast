package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleReaddatafromdb {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);//register the db driver
		//Step2: connect to db
		Connection conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		System.out.println("Connected Successfully");
		
		//Step3: Create sql statement
		Statement stat= conn.createStatement();
		
		//Step4:execute select query and give output
		ResultSet set=stat.executeQuery("select * from project");
		while(set.next())
		{
			System.out.println(set.getString(1)+ "\t" + set.getString(2));
			
		}
		
		// step5: close the connection
		conn.close();
			}

}

