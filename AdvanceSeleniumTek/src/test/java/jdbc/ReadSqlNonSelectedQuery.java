package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadSqlNonSelectedQuery {

	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);//register the db driver
		//Step2: connect to db
		Connection conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		System.out.println("Connected Successfully");
		
		//Step3: Create sql statement
		Statement stat= conn.createStatement();
		//Step 4: execute select query and get result
		int result=stat.executeUpdate("insert into project values('TY1000','kumar','04/28/2003','FB-00009','On Going','100');");
		System.out.println(result);
		
		
	}

}
