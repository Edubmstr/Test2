package OnlineShop;

public class Phone extends Product{

    public Phone(String name, int id, int price){
        super(name, id, price);
    }

    @Override
    protected boolean discountable() {
        return false;
    }
}
