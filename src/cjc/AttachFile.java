package cjc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttachFile extends SqlConnection{
	public void insertFile(String name,String friendName,String uname){
		System.out.println("FILE NAME :  " + name );
		String format = name.substring(name.indexOf('.')+1,name.length()) ;
		System.out.println("Friend Name : "+ friendName) ;
		try {

			File imgfile = new File("//home//dexter//Pictures//"+name);	  
			  FileInputStream fin = new FileInputStream(imgfile);
			   PreparedStatement pre = conn.prepareStatement("INSERT INTO TRANSFER(SENDERS,RECIEVERS,FILENAME,FORMAT,DATA) values(?,?,?,?,?)");
			 //sender's name
			   pre.setString(1,uname);
			   //receiver's name
			   pre.setString(2,friendName);
			   pre.setString(3, name);
			   pre.setString(4, format);
			   pre.setBinaryStream(5,(InputStream)fin,(int)imgfile.length());
			   pre.executeUpdate();
			   System.out.println("Successfully inserted the file into the database!");
			   pre.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	}
}
