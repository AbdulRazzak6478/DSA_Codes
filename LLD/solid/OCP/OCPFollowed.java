package LLD.solid.OCP;





import java.util.ArrayList;
import java.util.List;

// Product class representing any item in eCommerce.
class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// 1. ShoppingCart: Only responsible for Cart related business logic.
class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    void addProduct(Product p) { 
        products.add(p);
    }

    List<Product> getProducts() { 
        return products; 
    }

    double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }
}

// 2. ShoppingCartPrinter: Only responsible for printing invoices
class ShoppingCartPrinter {
    private ShoppingCart cart; 

    ShoppingCartPrinter(ShoppingCart cart) { 
        this.cart = cart; 
    }

    void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}

// 3. ShoppingCartStorage: Only responsible for saving cart to DB

interface DBPersistence {
    void save(ShoppingCart cart);
}
class SaveToSQL  implements DBPersistence{

    public void save(ShoppingCart cart) {
        System.out.println("Saving shopping cart to SQL DB...");
    }
}
class SaveToNoSQL  implements DBPersistence{

    public void save(ShoppingCart cart) {
        System.out.println("Saving shopping cart to NoSQL DB...");
    }
}
class SaveToFile  implements DBPersistence{

    public void save(ShoppingCart cart) {
        System.out.println("Saving shopping cart to File Storage...");
    }
}


public class OCPFollowed {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Macbook", 200000));
        cart.addProduct(new Product("fridge", 3000));
        cart.addProduct(new Product("iron", 5000));

        ShoppingCartPrinter invoice = new ShoppingCartPrinter(cart);

        invoice.printInvoice();

        DBPersistence sql = new SaveToSQL();
        DBPersistence nosql = new SaveToSQL();
        DBPersistence file = new SaveToSQL();

        sql.save(cart);
        nosql.save(cart);
        file.save(cart);
    }
}
