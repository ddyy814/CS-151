
public class hw4Q1b {
    public static void main(String[] args) {
        ModifySharedAccount sharedAccount = new ModifySharedAccount();
        int time = 15;
        int money = 50;

        // the first customer deposit
        Customer c1 = new Customer(sharedAccount, Customer.TYPE_DEPOSIT, time,money);
        // the second customer withdraw
        Customer c2 = new Customer(sharedAccount,Customer.TYPE_WITHDRAW,time,money);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();

    }
}
