
public class Main {
    public static void main(String[] args) {

        Product product = new Product();
        product.id = 1;
        product.name = "Laptop ";
        product.description = "A laptop for work";
        product.cost = 1000;
        product.price = 5000;

        ProductManager productManager = new ProductManager();
        productManager.add(product);


    }
}