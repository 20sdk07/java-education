public class InsufficientFundsExeption extends Exception {
    String message;
    public InsufficientFundsExeption(String masssge) {
        this.message = masssge;
        
    }
    @Override
    public String getMessage() {
        return message;
    }
}
