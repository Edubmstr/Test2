package Bank;

public class InsufficientFundsException extends Exception{

    public InsufficientFundsException(double amount){
        super("Auf dem Konto fehlen " + amount + " Euro!");
    }
}
