import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
public class AccountHolderTest {
    public static void main(String[] args) throws Exception {
        AccountHolder.annualInterestRate = 0.04;
        Scanner scanner = new Scanner(System.in);

        AccountHolder user = new AccountHolder(0);
        //Ask's user for initial balance and verifies input
        while (true) {
            System.out.print("Please enter your initial balance: ");
            double initBalance = scanner.nextDouble();
	        if (initBalance < 0){
                System.out.println("Your balance can't be negative, Please try again.");
                System.out.println();
            }
            else if (initBalance < 50){
                System.out.println("You must have at least $50 dollars in your account, Please try again.");
                System.out.println();
            }
	        else{
                user.setBalance(initBalance);
	            break;
            }
        }

        //Asks user for a amount to deposit
        while (true) {
            System.out.print("Enter a deposit amount: ");
            double depositAmount = scanner.nextDouble();
	        if (depositAmount < 0){
                System.out.println("You cant deposit a negative value, Please try again.");     
                System.out.println();       
            }
	        else{
                user.deposit(depositAmount);
	            break;
            }
        }

        //Asks user a withdraw amount
        while(true){
            System.out.print("Enter a withdrawal amount: ");
            double withdrawAmount = scanner.nextDouble();
            if (withdrawAmount < 0){
                System.out.println("Your withdraw must not be input as a negative number, try again.");
                System.out.println();
            }
            if (user.getBalance() - withdrawAmount < 50){
                System.out.println("You cannot have a balance less than $50, Please try again.");
                System.out.println();
            }
            else{
                user.withdrawal(withdrawAmount);
                break;
            }
        }
    
        System.out.println("");

        //Display sample of new balances over period of 12 months
        System.out.println("Montly Balances for one year at 0.04");
        System.out.println("Balances:");
        System.out.println("Account Balances with interest");
        System.out.println("Base: " + user.getBalance());

        for(int i = 1; i < 13; i++){
            System.out.print("Month " + i + ": ");
            user.monthlyInterest();
        }
        
        System.out.println("");

        //Provides the current time and student name
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Alexis Alvarez\n");
                
        scanner.close();

    }
}
