public class SharedAccount {

    private int balance = 100; // initial balance

    // create deposit without synchronized method
    public void deposit(int n) {
        balance = balance + n;
        try {
            Thread.sleep(300);
        } catch (Exception ignore) {
        }
        System.out.println(Thread.currentThread().getName() + " new balance is after deposit: $ " + balance);
    }

    // create withdraw without synchronized method
    public void withdraw(int n) {
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
