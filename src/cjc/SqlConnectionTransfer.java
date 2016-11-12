package cjc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnectionTransfer implements SQLConnection {
	public static Connection conn ;
	public SqlConnectionTransfer(){
		loadDB();
	}
	public void loadDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("SQLCONNECTION");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet getSentMessages(String user) throws SQLException{
		Statement statement=conn.createStatement();
		String sql ;
		sql="SELECT * FROM TRANSFER WHERE SENDERS = '" + user +"';";
		ResultSet resultSet = statement.executeQuery(sql);
		return resultSet ; 
	}
	public ResultSet getRecieveMessages(String user) throws SQLException{
		Statement statement=conn.createStatement();
		String sql ;
		sql="SELECT * FROM TRANSFER WHERE RECIEVERS = '" + user +"';";
		ResultSet resultSet = statement.executeQuery(sql);
		return resultSet ; 
	}
	public ResultSet downloadFile(int id) throws SQLException{
		String sql = "SELECT * FROM TRANSFER WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
		return result;
	}
	public void closeConnection() throws SQLException{
		conn.close();
	}
}