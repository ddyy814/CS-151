public class SharedAccount {
    public SharedAccount(){
        balance = 0;
    }
    public void deposit(double amount){
        balance = balance + amount;
        System.out.print("Depositing " + amount + ", new balance is " + balance);
        System.out.println();

    }
    public void withdraw(double amount){
        if(balance < amount){
            System.out.println("Non-sufficient funds");
            return;
        }
        balance = balance - amount;
        System.out.print("Withdrawing " + amount + ", new balance is " + balance);
        System.out.println();
    }

    public double getBalance(){
        return balance;
    }
    private double balance;
}
