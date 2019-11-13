public class WithdrawRunnable implements Runnable {
    private static final int DELAY = 300;
    private ModifySharedAccount account;
    private double amount;
    private int count;

    public WithdrawRunnable (ModifySharedAccount shAccount, double anAmount, int aCount){
        account = shAccount;
        amount = anAmount;
        count = aCount;
    }

    public void run(){
        try{
            for(int i = 1; i <= count; i++) {
                    account.withdraw(amount);
                    Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException exception){}
    }
}
