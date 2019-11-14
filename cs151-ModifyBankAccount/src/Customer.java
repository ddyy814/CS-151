public class Customer implements Runnable{

    static final String TYPE_DEPOSIT = "Deposit";
    static final String TYPE_WITHDRAW = "Withdraw";

    private ModifySharedAccount sharedAccount;
    private String type;
    private int time;
    private int money;

    public Customer(){}
    public Customer(ModifySharedAccount sharedAccount, String type, int time, int money){
        this.sharedAccount = sharedAccount;
        this.type = type;
        this.time = time;
        this.money = money;
    }
    @Override
    public void run(){
        for(int x =0; x < time; x++){
            if(TYPE_DEPOSIT.equals(type)){
                sharedAccount.deposit(money);
            }else if(TYPE_WITHDRAW.equals(type)){
                sharedAccount.withdraw(money);
            }
        }
    }
}
