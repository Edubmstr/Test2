package OnlineShop;

import Bank.InsufficientFundsException;
import Bank.Konto;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products = new ArrayList<>();
    private boolean discount = false;
    private double discountPercentage;

    Storage storage;

    public ShoppingCart(Storage storage){
        this.setStorage(storage);
    }

    private double priceAfterDiscount;

    public void addProduct(Product product, int amount){
        this.products.add(product);
        product.setAmount(amount);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    public void setStorage(Storage storage){
        this.storage = storage;
    }

    public double sumCart(){
        double sum = 0;
        for (Product product : products){
            sum += product.getPrice() * product.getAmount();
        }
        return sum;
    }

    public ArrayList<Product> getProducts(){
        return this.products; //maybe umschreiben damit amount mitreinkommt
    }

    public Product getProduct(int id){
        for(Product product : products){
            if(product.getID() == id){
                return product;
            }
        }
        return null;
    }

    private void discount(){
        for(Product product : products){
            if(product.getDiscountable()){
                setPriceAfterDiscount(product);
            }else{
                this.priceAfterDiscount += product.getPrice() * product.getAmount();
            }

        }
    }

    private void setPriceAfterDiscount(Product product){
        this.priceAfterDiscount += (product.getPrice() * product.getAmount()) * (1 - (discountPercentage / 100));
    }

    private double getNewPrice(){
        return priceAfterDiscount;
    }

    public void setDiscount(double discountPercentage){
        this.discount = true;
        this.discountPercentage = discountPercentage;
        discount();
    }

    public void order(Konto konto){
        for (Product product : products) {
            try{
                storage.getAvailibility(product);
            }catch (NoStockException e){
                System.out.println("Order could not be processed: Product " + product + " not available");
                System.out.println("Remove Product from Cart");
                this.priceAfterDiscount -= product.getPrice();
                return;
            }
        }
        try{
            if(discount){
                konto.payOut(this.getNewPrice());
            }else{
                konto.payOut(this.sumCart());
            }
            for (Product product : products) {
                this.storage.changeStock(product, product.getAmount());
            }
            System.out.println("Order succesfully created! Thank you " + konto.getName() + " for your oder!");
        } catch (InsufficientFundsException e) {
            System.out.println("Not enough money on account!");
        }
    }

}
