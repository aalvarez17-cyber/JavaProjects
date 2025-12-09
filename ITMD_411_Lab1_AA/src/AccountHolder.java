public class AccountHolder {
    private double balance;
    public static double annualInterestRate; 

    //Account holder constructor 
    public AccountHolder(double balance){   
        this.balance = balance;
    }

    //Account holder methods
    public void deposit(double balance){
        this.balance += balance;
    }

    public void withdrawal(double balance){        
        this.balance -= balance;
    }

    public void monthlyInterest(){
        //Updates balance after montly interest rate. 
        balance += balance * (annualInterestRate / 12.0);
        System.out.printf("Your balance with interest applied: $" + "%.2f", balance);
        System.out.println("");
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
