
public class Main {
    public static void main(String[] args) {
        CustomerManager cm = new CustomerManager();
         cm.dbManager = new OracleManager();
         cm.GetCustomer();

    }
}