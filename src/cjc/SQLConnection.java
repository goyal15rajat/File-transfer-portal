package cjc;

import java.sql.SQLException;

public interface SQLConnection {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/LAB";
	static final String USER = "root";
	static final String PASS = "root";
	void loadDB();
	void closeConnection() throws SQLException;

}
