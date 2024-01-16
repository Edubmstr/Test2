package OnlineShop;

import java.util.ArrayList;

public class Storage implements Sorting {
    private ArrayList<Product> stock;

    public Storage(){
        this.stock = new ArrayList<>();
    }

    public void addProducts(Product product, int stock){
        this.stock.add(product);
        product.setStock(stock);
    }

    public boolean getAvailibility(Product product) throws NoStockException{
        if(!(product.getAvailable())){
            throw new NoStockException();
        }
        return product.getAvailable();
    }

    public void changeStock(Product product,int change){
        product.changeStock(change);
    }

    public void newStock(Product product, int amount){
        product.changeStock(-amount);
    }

    @Override
    public void sortStock(){
        for (int i = 1; i < stock.size(); i++) {
            Product temp = stock.get(i);
            int j = i - 1;
            while(j >= 0 && stock.get(j).getAmount() > temp.getAmount()){
                stock.set(j + 1, stock.get(j));
                j--;
            }
            stock.set(j + 1, temp);
        }
    }
}
