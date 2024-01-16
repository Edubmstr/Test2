package Bank;

import java.util.ArrayList;

public class Bank {
    public static void main(String[] args) throws InsufficientFundsException {
        int i = 0;
        ArrayList<Konto> kontos = new ArrayList<>();
        Konto konto1 = new Konto(1, "Eduard Baumeister", 100);
        Girokonto girokonto1 = new Girokonto(2, "Max Mustermann", 345, 1000);
        kontos.add(girokonto1);
        Festgeld festgeld1 = new Festgeld(3, "Marie Musterfrau", -90, 2.5, 12);
        kontos.add(festgeld1);
        Sparkonto sparkonto1 = new Sparkonto(4, "Julian Konz", -789, -90);
        kontos.add(sparkonto1);
        Tagesgeld tagesgeld1 = new Tagesgeld(5, "Benny Will", 5789, 0.005);
        kontos.add(tagesgeld1);
        ExtendedBank bank1 = new ExtendedBank();
        bank1.addKonto(new Konto(6, "Moin Meister", 500));
        bank1.getKonto(6).printInfo();
        Festgeld konto3 = new Festgeld(10, "Max",626282, 0.9, 8);
        konto3.getLost();
        Konto konto2 = new Girokonto(11, "Juli", 10000, 50);
        Girokonto girokonto33 = new Girokonto(33, "Max", 500, 5);


        if(konto1 instanceof Girokonto){
            System.out.println("lol");
        }else{
            System.out.println("Nein");
        }

        for(Konto konto : kontos){
            konto.printInfo();
        }

        konto1.payIn(30);

        try{
            konto1.payOut(96715);
        }catch(InsufficientFundsException e){
            if(i == 3){
                throw e;
            }
            System.out.println(e.getMessage());
            i++;
        }

        try{
            konto1.payOut(96715);
        }catch(InsufficientFundsException e){
            if(i == 3){
                throw e;
            }
            System.out.println(e.getMessage());
            i++;
        }

        try{
            konto1.payOut(96715);
        }catch(InsufficientFundsException e){
            if(i == 3){
                throw e;
            }
            System.out.println(e.getMessage());
            i++;
        }

        try{
            konto1.payOut(96715);
        }catch(InsufficientFundsException e){
            if(i == 3){
                throw e;
            }
            System.out.println(e.getMessage());
            i++;
        }

    }
}
