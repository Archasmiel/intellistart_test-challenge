package objects;


public class User {

    private final String name;
    private final String lastname;
    private float money;



    public User(String name, String lastname, float money) {
        if (name == null || name.equals("")) throw new IllegalStateException("Illegal user name!");
        if (lastname == null || lastname.equals("")) throw new IllegalStateException("Illegal user last name!");
        if (money <= 0) throw new IllegalStateException("Illegal amount of money!");

        this.name = name;
        this.lastname = lastname;
        this.money = money;
    }






    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastname;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

}
