package java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Dbase {

	public Dbase()	{
	}

	public Connection connect(String db_connect_str, String db_userid, String db_password)	{
		Connection conn;
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(db_connect_str, db_userid, db_password);
		} catch(Exception e) {
			e.printStackTrace();
			conn = null;
		}
		return conn;    
	}

	public void importData(Connection conn,String filename)	{
		Statement stmt;
		String query;

		try
		{
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA INFILE '"+filename+ "' INTO TABLE testtable FIELDS TERMINATED BY ',';";
			stmt.executeUpdate(query);
		} catch(Exception e) {
			e.printStackTrace();
			stmt = null;
		}
	}
	
	/**
	 * LOAD DATA INFILE 'data.txt' INTO TABLE tbl_name
  	FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  	LINES TERMINATED BY '\r\n'
  	IGNORE 1 LINES;
	 */
}
