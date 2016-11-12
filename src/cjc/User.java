package cjc;

import java.sql.SQLException;
import java.util.HashMap;

public class User  extends SqlConnection{
	private String username , f_name , l_name , pwd , email , dob , gender ;
	private int checkuser = 0 ;
	public int getCheck(){
		return checkuser ;
	}
	public boolean username_available(String s) throws SQLException{
		if(usPass.containsKey(s))
			return true;
		return false;
	}
	public boolean login_hash(String uname , String pw){
		conn = connect_db();
		boolean auth = false;
		System.out.println("PRINTING ALL USERNAME AND PASSWORD");
		System.out.println(usPass);
		if(pw.equals(usPass.get(uname))){
			auth = true ;
			System.out.println("Auth : true");
		}
		if(auth){
			username = uname ;
			return true;
		}
		return false;
		
	}
	public boolean signup(UserDetails user_d) {
		conn = connect_db();
		System.out.println("Sign up");
		try {
			if(username_available(user_d.getUsername()))
			{	checkuser = 1;
			System.out.println("Checkuser STMT");
			return false; 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataUpdate(user_d);
		return true;
	}
	public HashMap<String, String> ret_hash() {
		// TODO Auto-generated method stub
		return usPass;
	}
	public UserDetails getDetails(String uname){
		conn = connect_db();
		UserDetails user ;
		user = getUserDetails(uname);
		if(user == null){
			System.out.println("CHECK NULL");
		}
		return user ;
	}
}
