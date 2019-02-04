import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import classes.Customer;
import db.Delete;
import db.Read;
import db.Update;
import db.Write;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException, ParserConfigurationException, SAXException {
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	Customer currentCustomer;
    	boolean isRunning = true;
    	
    	while (isRunning ) {
    		System.out.println("1. List all customers;");
    		System.out.println("2. Register new customer;");
    		System.out.println("3. Delete customer;");
    		System.out.println("4. Update customer;");
    		System.out.println("5. Login;");
    		System.out.println("6. Exit");
    		int choice = Integer.parseInt(reader.readLine());
    		
    		switch (choice) {
    		case 1: Read.readCustomers(); break;
    		case 2: Write.writeCustomer(); break;
    		case 3: Delete.deleteUser(); break;
    		case 4: Update.update(); break;
    		case 5: currentCustomer = Read.login();
    			boolean isLoggedIn = true;
    			while (isLoggedIn) {
            System.out.println("-------------------");
	    			System.out.println("1. List accounts; ");
	    			System.out.println("2. Open account; ");
	    			System.out.println("3. Deposit; ");
						System.out.println("4. Withdrawal; ");
            System.out.println("5. Transfer; ");
	    			System.out.println("6. Log out ");
	    			int choice2 = Integer.parseInt(reader.readLine());
	    			switch (choice2) {
	    			case 1: Read.displayAccounts(currentCustomer.getId()); break;
	    			case 2: Write.writeAccount(currentCustomer.getId()); break;
	    			case 3: currentCustomer.deposit(); break;
	    			case 4: currentCustomer.withdrawal(); break;
	    			case 5: currentCustomer.transfer(); break;
	    			case 6: isLoggedIn = false; break;
	    			}
    			}
    			break;
    		case 6: isRunning = false; break;
    		}
    	}
        

    }

}