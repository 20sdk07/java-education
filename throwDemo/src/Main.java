public class Main {

    public static void main(String[] args) {

        AccountManager accountManager = new AccountManager();
        accountManager.deposit(100);
        try {
            accountManager.withdraw(50);
            
        } catch (InsufficientFundsExeption e) {
            System.out.println(e.getMessage());
        }
       
        System.out.println( "Bakiye :"+accountManager.getBalance());
        try {
            accountManager.withdraw(52);
        } catch (InsufficientFundsExeption e) {
            System.out.println(e.getMessage());
        }
             
    
        

        




    }
}