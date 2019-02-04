package classes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import db.Read;
import db.Update;
import db.Write;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class Customer {
		
	private int id;
	private String fName;
	private String lName;
	private String login;
	private String password;
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
//	public Customer(String fName, String lName, String login, String password) {
//		this.fName = fName;
//		this.lName = lName;
//		this.login = login;
//		this.password = password;
//	}
	
	public void openAccount() throws NumberFormatException, IOException, SQLException {
		Write.writeAccount(this.id);
	}
	
	public void deposit() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter account id: ");
		int id = Integer.parseInt(reader.readLine());
		System.out.println("Enter amount to deposit: ");
		double amount = Double.parseDouble(reader.readLine());
		Account currentAccount = Read.getAccount(id);
		Update.deposit(id, currentAccount.getBalance() + amount);
	}

	public void withdrawal() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter account id: ");
		int id = Integer.parseInt(reader.readLine());
		System.out.println("Enter amount to withdrawal: ");
		double amount = Double.parseDouble(reader.readLine());
		Account currentAccount = Read.getAccount(id);
		Update.withdrawal(id, currentAccount.getBalance() - amount);
	}

	public void transfer() throws IOException, ParserConfigurationException, SAXException, SQLException {
		System.out.println("Enter account id from: ");
		int idFrom = Integer.parseInt(reader.readLine());
		Account from = Read.getAccount(idFrom);
		System.out.println("Enter account id to: ");
		int idTo = Integer.parseInt(reader.readLine());
		Account to = Read.getAccount(idTo);
		System.out.println("Enter amount: ");
		double amount = Double.parseDouble(reader.readLine());
		double newAmount = CurParser.convert(from.getCurrency().toString(), amount, to.getCurrency().toString());
		Update.withdrawal(from.getId(), from.getBalance() - amount);
		Update.deposit(to.getId(), to.getBalance() + newAmount);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
