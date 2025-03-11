public class AccountManager {
    private double balance;


    public void deposit(double amount) {
        balance += amount;

    }

    public void withdraw (double amount) throws InsufficientFundsExeption {
        if (balance >= amount) {
            
            balance -= amount;
        }else {
            throw new InsufficientFundsExeption("Yetersiz bakiye. \nMevcut bakiye :"+balance);

        }   
    }
    public double getBalance() {
        return balance;
    }
    

   
    
    

}
