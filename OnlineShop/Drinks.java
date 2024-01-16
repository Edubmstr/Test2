package OnlineShop;

public class Drinks extends Product{

    private int volume;

    public Drinks(String name, int id, double price, int volume){
        super(name, id, price);
        this.volume = volume;
    }


    @Override
    protected boolean discountable() {
        return true;
    }
}
