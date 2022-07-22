package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lib.IdGenerator.genID;

/**
 * Trade system object<br>
 * • users Map[String, User] - saving registered users<br>
 * • products Map[String, Product] - registered products<br>
 * • boughtProducts Map[String, List[String]] - list of products, bought by user
 */
public class TradeSystem {



    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Product> products = new HashMap<>();

    private final Map<String, List<String>> boughtProducts = new HashMap<>();



    public TradeSystem() {}

    /**
     * Checks if user and product exist
     * If user hasn't enough money to buy, throws exception
     * If user has enough money, subtracts price from users money
     * After buy, adds product to collection consisting of (userId: String, userProducts: List of String)
     * @param userId user id
     * @param productId product id
     */
    public void buyProduct(String userId, String productId) {
        User user = getUserById(userId);
        Product product = getProductById(productId);

        if (user.getMoney() < product.getPrice()) {
            throw new IllegalStateException("User '" + userId + "' doesn't have enough money for product '" + productId + "'!");
        }

        user.buyProduct(product);
        System.out.println(("User '" + userId + "' bought product '" + productId + "'!"));
        boughtProducts.get(userId).add(productId);
    }


    /**
     * Adds user to system
     * @param name user name
     * @param lastname user last name
     * @param money user money
     */
    public void addUser(String name, String lastname, float money) {
        String id = genID();

        users.put(id, new User(name, lastname, money));
        boughtProducts.put(id, new ArrayList<>());
        System.out.println("Added user with id '" + id + "'");
    }

    /**
     * Removes user from system and user product list
     * @param id user id
     * Throws exception if id doesn't exist
     */
    public void removeUser(String id){
        User user = getUserById(id);

        users.remove(id);
        boughtProducts.remove(id);
        System.out.println("Removed user with id '" + id + "'");
    }

    /**
     * Adds product to system
     * @param name product name
     * @param price product price
     */
    public void addProduct(String name, float price) {
        String id = genID();

        products.put(id, new Product(name, price));
        System.out.println("Added product with id '" + id + "'");
    }

    /**
     * Removes product from system and product list bought by user
     * @param id product id
     * Throws exception if id doesn't exist
     */
    public void removeProduct(String id){
        Product product = getProductById(id);

        products.remove(id);
        for (String i: boughtProducts.keySet()) {
            if (boughtProducts.get(i).size() == 0) return;

            List<String> list = new ArrayList<>();
            for (String j: boughtProducts.get(i)){
                if (!j.equals(id)) {
                    list.add(j);
                }
            }
            boughtProducts.put(i, list);
        }
        System.out.println("Removed product with id '" + id + "'");
    }






    /**
     * Returns product from system
     * @param id product id
     * @return product from system with given id
     * Throws exception if id is incorrect
     */
    public Product getProductById(String id) {
        if (products.containsKey(id))
            return products.get(id);

        throw new IllegalStateException("Product with id '" + id + "' not found in system!");
    }

    /**
     * Returns user from system
     * @param id user id
     * @return user from system with given id
     * Throws exception if id is incorrect
     */
    public User getUserById(String id) {
        if (users.containsKey(id))
            return users.get(id);

        throw new IllegalStateException("User with id '" + id + "' not found in system!");
    }




    /**
     * Returns table of users which was registered in system
     * @return String with visual table for print in console
     */
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

    /**
     * Returns table of products which was registered in system
     * @return String with visual table for print in console
     */
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

    /**
     * Returns table of products that user with current id bought earlier
     * @param id user id
     * @return String with visual table for print in console
     */
    public String getUserProducts(String id) {
        User user = getUserById(id);

        StringBuilder res = new StringBuilder();
        res.append("|-------------------------------|\n");
        res.append("| LIST OF '").append(id).append("' PRODUCTS |\n");
        res.append("|   ID   |   Name   |   Price   |\n");
        res.append("|-------------------------------|\n");

        List<String> userProducts = boughtProducts.get(id);

        if (userProducts.equals(new ArrayList<>())) return "User '" + id + "' didn't bought any products yet!";

        for (String boughtProduct: userProducts) {
            Product product = products.get(boughtProduct);
            res.append("| ").append(boughtProduct);
            res.append(" | ").append(product.getName());
            res.append(" | ").append(product.getPrice());
            res.append(" |\n");
        }

        res.append("|-------------------------------|");

        return res.toString();
    }

    /**
     * Returns table of users that bought product with given id
     * @param id product id
     * @return String with visual table for print in console
     */
    public String getProductUsers(String id) {
        Product product = getProductById(id);

        StringBuilder res = new StringBuilder();
        res.append("|-------------------------------|\n");
        res.append("|   LIST OF '").append(id).append("' USERS  |\n");
        res.append("|               ID             |\n");
        res.append("|-------------------------------|\n");

        int count = 0;

        for (String i: boughtProducts.keySet()) {
            for (String j: boughtProducts.get(i)){
                if (j.equals(id)){
                    res.append("|          ").append(i).append("           |\n");
                    count++;
                    break;
                }
            }
        }

        res.append("|-------------------------------|");

        if (count == 0) return "No one bought product + '" + id + "'!";
        return res.toString();
    }



}
