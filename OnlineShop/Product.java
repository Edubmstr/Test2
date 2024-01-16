package OnlineShop;

public abstract class Product {
    private String name;
    private int id;
    private double price;

    private int stock = 0;

    private boolean available = false;
    Storage storage;

    private int amount = 0;


    public Product(String name, int id, double price){
        this.name = name;
        this.id = id;
        this.price = price;
        setAvailable();
        setStorage(storage);
    }

    public void changePrice(double newPrice){
        this.price = newPrice;
    }

    private void setStorage(Storage storage){
        this.storage = storage;

    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    public double getPrice(){
        return this.price;
    }

    public String toString(){
        return this.name;
    }

    public int getID(){
        return this.id;
    }

    protected abstract boolean discountable();

    public boolean getDiscountable(){
        return discountable();
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public boolean getAvailable(){
        setAvailable();
        return available;
    }

    public void changeStock(int change){
        this.stock -= change;
    }

    private void setAvailable(){
        if(this.stock > getAmount()){
            this.available = true;
        }else{
            this.available = false;
        }
    }
}
