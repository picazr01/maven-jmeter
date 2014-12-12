package java;

import java.sql.Connection;

public class main {
	public static void main(String[] args) {
		 Dbase db = new Dbase();
	     Connection conn = db.connect("jdbc:mysql://localhost:3306/test","root","caspian");
	     db.importData(conn,args[0]);
	}
}
