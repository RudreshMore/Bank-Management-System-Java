package in.rudresh;

import java.util.*;

class BankAccount {
	private int accNumber;
	private String name;
	private double balance;

	public BankAccount(int accNumber, String name, double balance) {
		this.accNumber = accNumber;
		this.name = name;
		this.balance = balance;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public boolean withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return accNumber + " | " + name + " | " + balance;
	}
}

public class BankApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<BankAccount> accounts = new ArrayList<>();

		while (true) {
			System.out.println("\n===== BANK MENU =====");
			System.out.println("1. Create Account");
			System.out.println("2. View All Accounts");
			System.out.println("3. Deposit Money");
			System.out.println("4. Withdraw Money");
			System.out.println("5. Check Balance");
			System.out.println("6. Delete Account");
			System.out.println("7. Exit");
			System.out.print("Enter choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				createAccount(accounts, sc);
				break;
			case 2:
				viewAccounts(accounts);
				break;
			case 3:
				depositMoney(accounts, sc);
				break;
			case 4:
				withdrawMoney(accounts, sc);
				break;
			case 5:
				checkBalance(accounts, sc);
				break;
			case 6:
				deleteAccount(accounts, sc);
				break;
			case 7:
				System.out.println("Thank you for banking with us!");
				System.exit(0);
			default:
				System.out.println("Invalid choice!");
			}
		}
	}

	public static void createAccount(ArrayList<BankAccount> accounts, Scanner sc) {
		System.out.print("Enter Account Number: ");
		int accNo = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Initial Balance: ");
		double bal = sc.nextDouble();

		accounts.add(new BankAccount(accNo, name, bal));
		System.out.println("Account Created Successfully!");
	}

	public static void viewAccounts(ArrayList<BankAccount> accounts) {
		System.out.println("\n--- All Bank Accounts ---");
		for (BankAccount acc : accounts) {
			System.out.println(acc);
		}
	}

	public static void depositMoney(ArrayList<BankAccount> accounts, Scanner sc) {
		System.out.print("Enter Account Number: ");
		int accNo = sc.nextInt();

		for (BankAccount acc : accounts) {
			if (acc.getAccNumber() == accNo) {
				System.out.print("Enter Amount: ");
				double amt = sc.nextDouble();
				acc.deposit(amt);
				System.out.println("Deposit Successful!");
				return;
			}
		}
		System.out.println("Account not found!");
	}

	public static void withdrawMoney(ArrayList<BankAccount> accounts, Scanner sc) {
		System.out.print("Enter Account Number: ");
		int accNo = sc.nextInt();

		for (BankAccount acc : accounts) {
			if (acc.getAccNumber() == accNo) {
				System.out.print("Enter Amount: ");
				double amt = sc.nextDouble();
				if (acc.withdraw(amt)) {
					System.out.println("Withdrawal Successful!");
				} else {
					System.out.println("Insufficient Balance!");
				}
				return;
			}
		}
		System.out.println("Account not found!");
	}

	public static void checkBalance(ArrayList<BankAccount> accounts, Scanner sc) {
		System.out.print("Enter Account Number: ");
		int accNo = sc.nextInt();

		for (BankAccount acc : accounts) {
			if (acc.getAccNumber() == accNo) {
				System.out.println("Balance: " + acc.getBalance());
				return;
			}
		}
		System.out.println("Account not found!");
	}

	public static void deleteAccount(ArrayList<BankAccount> accounts, Scanner sc) {
		System.out.print("Enter Account Number: ");
		int accNo = sc.nextInt();

		Iterator<BankAccount> itr = accounts.iterator();

		while (itr.hasNext()) {
			if (itr.next().getAccNumber() == accNo) {
				itr.remove();
				System.out.println("Account Deleted!");
				return;
			}
		}
		System.out.println("Account not found!");
	}

}
