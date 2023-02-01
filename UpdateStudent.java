package assignment5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "system";
		String password = "rumi281200";
		
		String query = "";
		String sval = "";
		int ival = 0;
		String scon = "";
		int icon = 0;
		
		try {
			
			//connection created
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successful");
			
			//to check the column names of table student
			String selectQuery = "select * from student";
			Statement selectST = con.createStatement();
			ResultSet rs = selectST.executeQuery(selectQuery);
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("The columns present in the table are: ");
			for(int i=1; i<=rsmd.getColumnCount(); i++) {
				System.out.println(rsmd.getColumnName(i));
			}
			System.out.println();
			
			
			System.out.println("You cannot update the ID as it is the auto-generated primary key\n");
			System.out.println("Now enter the column you wanna update: ");
			String colName = sc.nextLine().toUpperCase();
			
			System.out.println("Enter the value: ");
			if(colName.equals("NAME") || colName.equals("ADDRESS")) {
				sval = sc.nextLine();
			}
			else {
				ival = sc.nextInt();
				sc.nextLine();
			}

			System.out.println("Now enter the condition column: ");
			String condition = sc.nextLine().toUpperCase();
			
			System.out.println("Enter the value: ");
			if(condition.equals("NAME") || condition.equals("ADDRESS")) {
				scon = sc.nextLine();
			}
			else {
				icon = sc.nextInt();
				sc.nextLine();
			}
			
			if((colName.equals("NAME") || colName.equals("ADDRESS")) && (condition.equals("NAME") || condition.equals("ADDRESS"))) {
				query = "update student set " + colName + " = " + "'" + sval + "'" + " where " + condition + " = " + "'" + scon + "'";
			}
			
			else if((colName.equals("NAME") || colName.equals("ADDRESS")) && (condition.equals("ID") || condition.equals("AGE") || condition.equals("COURSE"))) {
				query = "update student set " + colName + " = " + "'" + sval + "'" + " where " + condition + " = " + icon;

			}
			
			else if((colName.equals("ID") || colName.equals("AGE") || colName.equals("COURSE")) && (condition.equals("NAME") || condition.equals("ADDRESS"))) {
				query = "update student set " + colName + " = " + ival + " where " + condition + " = " + "'" + scon + "'";

			}
			
			else {
				query = "update student set " + colName + " = " + ival + " where " + condition + " = " + icon;

			}
		
			Statement st = con.createStatement();
	        int x=st.executeUpdate(query);
			System.out.println(x+" record updated successfully");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
