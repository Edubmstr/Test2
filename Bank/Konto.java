package Bank;

import java.util.ArrayList;

public class Konto {
    protected int nummer;
    protected String name;
    protected int saldo;
    public Konto(int nummer, String name, int saldo){
        this.nummer = nummer;
        this.name = name;
        this.saldo = saldo;
    }

    public void payIn(double sum){
        saldo += sum;
        System.out.println("Betrag von " + sum + " Euro wurde erfolgreich verbucht");
        System.out.println("Neuer Kontostand: " + saldo + " Euro");
    }

    public void payOut(double sum)
        throws InsufficientFundsException {

            if (sum > saldo) {
                throw new InsufficientFundsException(sum - saldo);
            } else {
                saldo -= sum;
                System.out.println("Betrag von " + sum + " Euro wurde erfolgreich abgehoben");
                System.out.println("Neuer Kontostand: " + saldo + " Euro");
            }
        }


    public void printInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("Nummer: " + nummer);
        System.out.println("Saldo: " + saldo);
    }

    public int getNummer(){
        return this.nummer;
    }

    public String getName(){
        return this.name;
    }
}
