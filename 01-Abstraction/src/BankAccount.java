
public class BankAccount {
	
	private double balance;

	public BankAccount(double balance) {
		this.balance = balance;
	}

	public BankAccount() {
		super();
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public double getInterestAmount() {
		return balance*0.10;
	}
	
	public double getInterestAmount(double interestRate) {
		return balance*interestRate;
	}
	
	
	
	
	

}
