package db;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Update {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void update() throws NumberFormatException, IOException, SQLException {
		
		System.out.println("Enter id to update: ");
		int idToUpdate = Integer.parseInt(reader.readLine());
		
		System.out.println("Enter new first name:" );
		String newfName = reader.readLine();
		
		System.out.println("Enter new last name: ");
		String newlName = reader.readLine();
		
		DBUtilities dbUtilities = new DBUtilities();
		String sql = "update customer set fName = '" + newfName + "', lName = '" + newlName + "' where id = " + idToUpdate;
		dbUtilities.ExecuteSQLStatement(sql);
		
		
	}
	
    public static void deposit(int id, double amount) throws SQLException {
			setUpdate(id, amount, " where id = ");
		}

		public static void withdrawal(int id, double amount) throws SQLException {
			setUpdate(id, amount, "where id = ");
		}

		private static void setUpdate(int id, double amount, String s) throws SQLException {
			DBUtilities dbUtilities = new DBUtilities();
			String sql = "update account set balance = " + amount + s + id;
			dbUtilities.ExecuteSQLStatement(sql);
		}

}
