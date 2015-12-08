package helperClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void updateTable(String query, String db)
	{
		String user="root";
		String password="";
		try{
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudproject",user,password);
        Statement stmt = con.createStatement();
        //System.out.println("Created DB Connection....");
			stmt.executeUpdate(query);
			//con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static ResultSet getResultSet(String query)
	{
		String user="root";
		String password="";
		ResultSet rs=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudproject",user,password);
	        Statement stmt = con.createStatement();
	        //System.out.println("Created DB Connection....");
				rs=stmt.executeQuery(query);
				//con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		return rs;
	}

}
