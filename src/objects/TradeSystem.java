package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lib.IdGenerator.genID;

public class TradeSystem {

    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Product> products = new HashMap<>();

    private final Map<String, List<Pair<String, Product>>> boughtProducts = new HashMap<>();



    public TradeSystem() {}

    public void buyProduct(String userId, String productId) {
        User user = getUserById(userId);
        Product product = getProductById(productId);

        if (user.getMoney() < product.getPrice()) {
            throw new IllegalStateException("User '" + userId + "' doesn't have enough money for product '" + productId + "'!");
        }

        user.setMoney(user.getMoney() - product.getPrice());
        System.out.println(("User '" + userId + "' bought product '" + productId + "'!"));
        boughtProducts.get(userId).add(new Pair<>(productId, product));
    }





    public void addUser(String name, String lastname, float money) {
        String id = genID();
        users.put(id, new User(name, lastname, money));
        boughtProducts.put(id, new ArrayList<>());
        System.out.println("Added user with id '" + id + "'");
    }

    public void addProduct(String name, float price) {
        String id = genID();
        products.put(id, new Product(name, price));
        System.out.println("Added product with id '" + id + "'");
    }





    public Product getProductById(String id) {
        if (products.containsKey(id))
            return products.get(id);

        throw new IllegalStateException("Product with id '" + id + "' not found in system!");
    }

    public User getUserById(String id) {
        if (users.containsKey(id))
            return users.get(id);

        throw new IllegalStateException("User with id '" + id + "' not found in system!");
    }




    public String getUsers() {
        StringBuilder res = new StringBuilder();

        res.append("|-----------------------------------------------|\n");
        res.append("|               LIST OF USERS                   |\n");
        res.append("|   ID   |   Name   |   Last Name   |   Money   |\n");
        res.append("|-----------------------------------------------|\n");

        User user;
        for (String id: users.keySet()) {
            user = users.get(id);
            res.append("| ").append(id);
            res.append(" | ").append(user.getName());
            res.append(" | ").append(user.getLastName());
            res.append(" | ").append(user.getMoney());
            res.append(" |\n");
        }

        res.append("|-----------------------------------------------|");

        return res.toString();
    }

    public String getProducts() {
        StringBuilder res = new StringBuilder();
        res.append("|-------------------------------|\n");
        res.append("|       LIST OF PRODUCTS        |\n");
        res.append("|   ID   |   Name   |   Price   |\n");
        res.append("|-------------------------------|\n");

        Product product;
        for (String id: products.keySet()) {
            product = products.get(id);
            res.append("| ").append(id);
            res.append(" | ").append(product.getName());
            res.append(" | ").append(product.getPrice());
            res.append(" |\n");
        }

        res.append("|-------------------------------|");

        return res.toString();
    }

    public String getUserProducts(String id) {
        User user = getUserById(id);

        StringBuilder res = new StringBuilder();
        res.append("|-------------------------------|\n");
        res.append("| LIST OF '").append(id).append("' PRODUCTS |\n");
        res.append("|   ID   |   Name   |   Price   |\n");
        res.append("|-------------------------------|\n");

        List<Pair<String, Product>> products = boughtProducts.get(id);

        if (products.equals(new ArrayList<>())) return "";

        for (Pair<String, Product> boughtProduct: products) {
            res.append("| ").append(boughtProduct.getLeft());
            res.append(" | ").append(boughtProduct.getRight().getName());
            res.append(" | ").append(boughtProduct.getRight().getPrice());
            res.append(" |\n");
        }

        res.append("|-------------------------------|");

        return res.toString();
    }



}
