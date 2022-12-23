package Utility;

import java.sql.Connection;


//Demo for checking the connection is stabilized or not
public class Demo {
public static void main(String[] args) {
	Connection conn=DButil.ProvideConnection();
	
	System.out.println(conn);
}
}
