package assignment5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "system";
		String password = "rumi281200";
		
		try {
			
			//creating the connection
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successful");
			
			//a variable to print the total no of insertions
			int c = 0;
			
			//to take input as long as user wants it
			while(true) {
				System.out.println("ID is auto-generated");
				System.out.println("Now enter the inputs: ");
				
				System.out.println("Name: ");
				String name = sc.nextLine();
				
				System.out.println("Age: ");
				int age = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Address: ");
				String address = sc.nextLine();
				
				System.out.println("Course Id: ");
				int course = sc.nextInt();
				sc.nextLine();
				
				String query="insert into student(name,age,address,course) values(" + "'" + name + "'," + age + ",'" + address + "'," + course + ")";
				
		        Statement st = con.createStatement();
		        int x=st.executeUpdate(query);
				System.out.println(x+" record inserted successfully");
				c++;
				
				System.out.println("Do you want to continue?\nType yes/no");
				String ch  = sc.nextLine();
				if(ch.equals("yes"))
					continue;
				else {
					System.out.println("EXIT");
					break;
				}
			}
			
			System.out.println("Total entries: " + c );
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
