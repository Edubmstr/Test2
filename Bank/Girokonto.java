package Bank;

public class Girokonto extends Konto{
    private double overdraft;
    public Girokonto(int nummer, String name, int saldo, double overdraft) {
        super(nummer, name, saldo);
        this.overdraft = overdraft;
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Überziehungsrahmen: " + overdraft);
    }

    @Override
    public void payOut(double sum) throws InsufficientFundsException{
        if(saldo + overdraft > sum){
            saldo -= sum;
            System.out.println("Betrag von " + sum + " Euro wurde erfolgreich abgebucht");
            System.out.println("Neuer Kontostand: " + saldo + " Euro");
        }else{
            throw new InsufficientFundsException(sum - saldo);
        }
    }
}
