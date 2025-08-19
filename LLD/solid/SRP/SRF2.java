import java.util.ArrayList;
import java.util.List;

class Product {

    public String name;
    public double price;

    public Product(String name, double price)
    {
    
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart {

    public List<Product> products = new ArrayList<>();

    public void addProduct(Product p)
    {
        products.add(p);
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public double calculateTotal()
    {
        double total = 0;
        for(Product p : products)
        {
            total+=p.price;
        }

        return total;
    }

}

class ShoppingCartPrinter {
    ShoppingCart cart;

    public ShoppingCartPrinter(ShoppingCart cart)
    {
        this.cart = cart;
    }
    public void printInvoice()
    {
        for(Product p : cart.getProducts())
        {
            System.out.println("Product Name: "+p.name+" , Price : "+p.price);
        }
        System.out.println("Total : "+cart.calculateTotal());
    }
}

// 3. ShoppingCartStorage: Only responsible for saving cart to DB
class ShoppingCartStorage {
    private ShoppingCart cart;

    public ShoppingCartStorage(ShoppingCart cart) {
        this.cart = cart;
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}

public class SRF2 {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));

        System.out.println("total : "+cart.calculateTotal());
        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        ShoppingCartStorage db = new ShoppingCartStorage(cart);
        db.saveToDatabase();
    }
}