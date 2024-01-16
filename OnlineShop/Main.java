package OnlineShop;

import Bank.Girokonto;

public class Main {
    public static void main(String[] args) {
        Phone product = new Phone("IPhone 15", 1, 1200);
        Phone product1 = new Phone("S23 Ultra", 2, 1300);
        Drinks product2 = new Drinks("Wasser", 3, 0.50, 500);
        Storage storage1 = new Storage();
        storage1.addProducts(product, 20);
        storage1.addProducts(product1, 50);
        storage1.addProducts(product2, 30);

        ShoppingCart cart1 = new ShoppingCart(storage1);
        Girokonto konto1 = new Girokonto(1, "Eduard Baumeister", 20000, 1000);



        cart1.addProduct(new Drinks("Cola", 4, 1.5, 1000), 1);
        storage1.addProducts(cart1.getProduct(4), 100);
        cart1.addProduct(product, 1);
        cart1.addProduct(product1, 2);
        cart1.addProduct(product2, 3);

        product1.setStock(0);

        System.out.println(cart1.getProduct(4));

        System.out.println(cart1.getProducts());

        System.out.println(cart1.sumCart());

        cart1.setDiscount(25);

        cart1.order(konto1);

        cart1.removeProduct(product1);

        cart1.order(konto1);

    }
}
