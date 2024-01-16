package Bank;

public class Festgeld extends Sparkonto{

    private int durationMonths;
    public Festgeld(int nummer, String name, int saldo, double zins, int durationMonths) {
        super(nummer, name, saldo, zins);
        this.durationMonths = durationMonths;
    }

    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Haltedauer: " + durationMonths + " Monate");
    }

    public void getLost(){

    }
}
