package metireDAO;


import java.sql.Connection;
import java.sql.DriverManager;


public class Connect {
	 private static Connection con;
	 static {
		 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");  
					System.out.println("driver ok");
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/catalogue","root","");
		            System.out.println("Connection OK");
				}catch (Exception e) {
					e.printStackTrace();
				}
			 

	 		}
	 public static Connection getConnection() {
		 return con;
	 }
}
