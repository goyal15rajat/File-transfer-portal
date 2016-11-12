package cjc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnectionFriends implements SQLConnection {
	public static Connection conn ;
	public SqlConnectionFriends(){
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
	public int addFriend(String friend_user) throws SQLException{
		Statement statement=conn.createStatement();
		String sql =  "INSERT INTO FRIENDS SELECT * FROM (SELECT '"+ UserName.USERNAME +"','"+ friend_user +"') AS TMP WHERE NOT EXISTS (SELECT FRIENDTEMP.FRIEND FROM (SELECT A.FOLLOWING AS FRIEND FROM FRIENDS A WHERE A.FOLLOWED = '"+ UserName.USERNAME +"' UNION SELECT B.FOLLOWED FROM FRIENDS B WHERE B.FOLLOWING = '"+ UserName.USERNAME +"')FRIENDTEMP WHERE FRIENDTEMP.FRIEND = '" + friend_user +"') LIMIT 1;";
		int resultset = statement.executeUpdate(sql);
		return resultset ;
	}
	public ResultSet getFriendlist() throws SQLException{
		Statement statement=conn.createStatement();
		String sql = "SELECT A.FOLLOWING AS FRIEND FROM FRIENDS A WHERE A.FOLLOWED = '"+ UserName.USERNAME +"' UNION SELECT B.FOLLOWED FROM FRIENDS B WHERE B.FOLLOWING = '"+ UserName.USERNAME +"';";
		ResultSet resultset = statement.executeQuery(sql); 
		return resultset; 
	}
	public ResultSet searchUser(String pid,Connection con) throws SQLException{
		ResultSet rs = SqlConnection.searchUser(pid,con);
		return rs;
	}
	public ResultSet searchUser(String pid) throws SQLException{
		ResultSet rs = searchUser(pid,conn);
		return rs;
	}
	public void closeConnection() throws SQLException{
		conn.close();
	}
}