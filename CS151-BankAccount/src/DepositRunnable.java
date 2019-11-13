public class DepositRunnable implements Runnable {

    private static final int DELAY = 300;
    private SharedAccount account;
    private double amount;
    private int count;

    public DepositRunnable(SharedAccount shAccount, double anAmount, int aCount){
        account = shAccount;
        amount = anAmount;
        count = aCount;
    }
    public void run() {
        try {
            for (int i = 1; i <= count; i++) {
                account.deposit(amount);
                Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException exception) {
        }
    }
}

