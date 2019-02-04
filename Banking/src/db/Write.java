package db;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import classes.Currency;

public class Write {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeCustomer() throws SQLException, IOException {
        System.out.println("Enter a first name: ");
        String fName = reader.readLine();
        System.out.println("Enter an last name: ");
        String lName = reader.readLine();
        System.out.println("Enter login: ");
        String login = reader.readLine();
        System.out.println("Enter password: ");
        String password = reader.readLine();

        DBUtilities dbUtilities = new DBUtilities();

        String sql = "insert into customer (fName, lName, login, password) "
        		+ "values ('" + fName + "', '" + lName + "', '" + login + "', '" + password + "');";
        dbUtilities.ExecuteSQLStatement(sql);

    }
    
    
    public static void writeAccount(int id) throws NumberFormatException, IOException, SQLException {
    	System.out.println("Choose currency: ");
		System.out.println("1. USD");
		System.out.println("2. EUR");
		System.out.println("3. CZK");
		int choice = Integer.parseInt(reader.readLine());
		Currency currency = null;
		switch (choice) {
		case 1: currency = Currency.USD; break;
		case 2: currency = Currency.EUR; break;
		case 3: currency = Currency.CZK; break;
		}
		
		DBUtilities dbUtilities = new DBUtilities();
		String sql = "insert into account(owner_id, currency, balance) values ( " + id + ", '" + currency.toString() + "', " + 0.0 + ");";
		
		dbUtilities.ExecuteSQLStatement(sql);
		
    }

}