public class ModifySharedAccount {

    private int balance = 100; // initial balance

    // synchronized block;
    // Object obj = new Object();

    // create deposit with synchronized method to avoid safety issue for threads
    public synchronized void deposit(int n) {
        // synchronized(obj){
        balance = balance + n;
        try {
            Thread.sleep(300);
        } catch (Exception ignore) {
        }
        System.out.println(Thread.currentThread().getName() + " new balance is after deposit: $ " + balance);
    //}
}

    // create withdraw with synchronized method to avoid safety issue for threads
    public synchronized void withdraw(int n) {
        if (balance >= 0) {
            balance = balance - n;
        } else {
            System.out.println("Non-sufficient funds");
        }
        try {
            Thread.sleep(200);
        } catch (Exception ignore) {
        }
        System.out.println(Thread.currentThread().getName() + " new balance is after withdraw: $ " + balance);
    }
}
