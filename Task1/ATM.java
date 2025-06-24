package Task1;
import java.util.Scanner;
public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private static Account currentAccount;

    public static void main(String[] args) {
        Account account = new Account("user123", "1234", 10000.00);
        Account account2 = new Account("user1234", "12345", 20000.00);

        System.out.println("====== Welcome to the ATM ======");
        System.out.print("Enter User ID: ");
        String enteredUserId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        if (enteredUserId.equals(account.getUserId()) && account.authenticate(enteredPin)) {
            currentAccount = account;
            System.out.println("Login successful!");
            showMenu();
        }
       else if (enteredUserId.equals(account2.getUserId()) && account2.authenticate(enteredPin)) {
            currentAccount = account2;
            System.out.println("Login successful!");
            showMenu();
        }
         else {
            System.out.println("Invalid credentials. Exiting.");
        }
    }

    public static void showMenu() {
        int choice;
        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + currentAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = scanner.nextDouble();
                    currentAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    currentAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. ");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }
    
}
