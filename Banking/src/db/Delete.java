package db;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Delete {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void deleteUser() throws NumberFormatException, IOException, SQLException {
		
		System.out.println("Enter id to delete: ");
		int idToDelete = Integer.parseInt(reader.readLine());
		
		DBUtilities dbUtilities = new DBUtilities();
		String sql = "delete from account where owner_id = " + idToDelete;
		String sql2 = "delete from customer where id = " + idToDelete;
		dbUtilities.ExecuteSQLStatement(sql);
		dbUtilities.ExecuteSQLStatement(sql2);
		
	}
	
	public static void deleteAccount() throws NumberFormatException, IOException, SQLException {
		
		System.out.println("Enter id to delete: ");
		int idToDelete = Integer.parseInt(reader.readLine());
		
		DBUtilities dbUtilities = new DBUtilities();
		String sql = "delete from account where id = " + idToDelete;
		dbUtilities.ExecuteSQLStatement(sql);
		
	}
	
}
