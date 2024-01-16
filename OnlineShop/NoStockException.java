package OnlineShop;

public class NoStockException extends Exception{

    public NoStockException(){
        super("Not enough stock available");
    }
}
