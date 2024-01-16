package Bank;

public class Sparkonto extends Konto {
    private double zins;
    public Sparkonto(int nummer, String name, int saldo, double zins) {
        super(nummer, name, saldo);
        this.zins = zins;
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Zins: " + zins + " %");
    }
}
