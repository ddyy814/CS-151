
public class hw4Q1a {
    public static void main(String[] args) {
        SharedAccount account = new SharedAccount();
        final double AMOUNT = 10;
        final int Repeating = 5;

        DepositRunnable deposit = new DepositRunnable(account, AMOUNT, Repeating);
        WithdrawRunnable withdraw = new WithdrawRunnable(account, AMOUNT, Repeating);

        Thread t1 = new Thread(deposit);
        Thread t2 = new Thread(withdraw);

        t1.start();
        t2.start();
    }
}
