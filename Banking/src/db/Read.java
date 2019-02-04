package db;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

import classes.Account;
import classes.Currency;
import classes.Customer;

public class Read {
	
	public static Customer login() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Customer customer = new Customer();
		System.out.println("Enter login: ");
		String login = reader.readLine().trim();
		System.out.println("Enter password: ");
		String password = reader.readLine().trim();
		
		try {
			DBUtilities dbUtilities = new DBUtilities();
			String sql = "select id, fName, lName from customer where login = '"
			+ login + "' and password = '" + password + "';";
			ResultSet resultSet = dbUtilities.ReadRecords(sql);
			
			while (resultSet.next()) {
                //Retrieve by column name
                int id = resultSet.getInt("id");
                String fName = resultSet.getString("fName");
                String lName = resultSet.getString("lName");
                
                customer.setId(id);
                customer.setfName(fName);
                customer.setlName(lName);
		}
			 dbUtilities.DisconnectFromDB();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();

        }
		return customer;
		
	}
	
	public static Account getAccount(int id) {
		Account account = new Account();
		try {
            DBUtilities dbUtilities = new DBUtilities();

            String sql = "select id, balance, currency from account where id = " + id;
            ResultSet resultSet = dbUtilities.ReadRecords(sql);
            
            while (resultSet.next()) {
    			account.setId(resultSet.getInt("id"));
    			account.setBalance(resultSet.getDouble("balance"));
    			String currency = resultSet.getString("currency");
    			if (currency.equals("USD")) {
    				account.setCurrency(Currency.USD);
    			} else if (currency.equals("EUR")) {
    				account.setCurrency(Currency.EUR);
    			} else if (currency.equals("CZK")) {
    				account.setCurrency(Currency.CZK);
    			}
            }
            dbUtilities.DisconnectFromDB();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();

        }
		
		return account;
            
	}

    public static void readCustomers() throws SQLException {

        dispayCustomers();

    }
    
    public static void readAccounts(int id) throws SQLException {
    	displayAccounts(id);
    }

    private static void dispayCustomers() throws SQLException {

        try {
            DBUtilities dbUtilities = new DBUtilities();

            String sql = "SELECT id, fName, lName FROM customer";
            ResultSet resultSet = dbUtilities.ReadRecords(sql);

            while (resultSet.next()) {
                //Retrieve by column name
                int id = resultSet.getInt("id");
                String fName = resultSet.getString("fName");
                String lName = resultSet.getString("lName");

                //Display values
                System.out.println("ID: " + id + ", Name: " + fName + " " + lName);
            }

            dbUtilities.DisconnectFromDB();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();

        }
    }
    
    public static void displayAccounts(int owner_id) {
    	try {
    		DBUtilities dbUtilities = new DBUtilities();
    		
    		String sql = "select id, balance, currency from account where owner_id = " + owner_id;
    		ResultSet resultSet = dbUtilities.ReadRecords(sql);
    		
    		while (resultSet.next()) {
    			int id = resultSet.getInt("id");
    			double balance = resultSet.getDouble("balance");
    			String currency = resultSet.getString("currency");
    			
    			System.out.println(id + ". " + balance + " " + currency);
    		}
    		dbUtilities.DisconnectFromDB();
    	} catch (SQLException e) {
    		e.printStackTrace();
    		
    	}
    }

}