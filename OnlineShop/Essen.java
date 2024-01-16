package OnlineShop;

public class Essen extends Product{
    public Essen(String name, int id, double price) {
        super(name, id, price);
    }

    @Override
    protected boolean discountable() {
        return false;
    }
}
