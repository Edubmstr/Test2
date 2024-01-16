package Bank;

import java.util.ArrayList;

public class ExtendedBank {

    private ArrayList<Konto> kontos;

    public ExtendedBank(){
        this.kontos = new ArrayList<>();
    }

    public void addKonto(Konto konto){
        kontos.add(konto);
    }

    public Konto getKonto(int number){
        for(Konto konto : kontos){
            if (konto.getNummer() == number){
                return konto;
            }
        }
        return null;
    }
}
