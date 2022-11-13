import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Coffeehouse {
    String name;
    MenuItem[] menu = new MenuItem[6];
    List<String> orders = new ArrayList<>();

    public Coffeehouse() {
        this.name = "Maor's Coffee";
        this.menu[0] = new MenuItem("Lemonade", "Drink", 3.5);
        this.menu[1] = new MenuItem("Coffee", "Drink", 1.3);
        this.menu[2] = new MenuItem("Pasta", "Food", 15);
        this.menu[3] = new MenuItem("Sandwich", "Food", 7.5);
        this.menu[4] = new MenuItem("Cornflakes", "Food", 4.75);
        this.menu[5] = new MenuItem("Beef Wellington", "Food", 12.5);

    }

    public void addOrder(String item) {
        if (IsInMenu(item))
            this.orders.add(item);
        else
            System.out.println("The item isn't available");
    }

    public String cheapestItem() {
        double min = this.menu[0].price;
        String nameOf = this.menu[0].ItemName;
        for (int i = 1; i < this.menu.length; i++) {
            if (this.menu[i].price < min) {
                min = this.menu[i].price;
                nameOf = this.menu[i].ItemName;
            }
        }

        return nameOf;
    }

    public String[] listOrders() {
        return orders.toArray(new String[0]);
    }

    public double dueAmount() {
        double result = 0;
        for (String order : orders) {
            result += findPrice(order);
        }
        return result;
    }

    public List<String> DrinksOnly() {
        List<String> retList = new ArrayList<>();
        for (MenuItem item : this.menu) {
            if (Objects.equals(item.type, "Drinks")) {
                retList.add(item.ItemName);
            }
        }
        return retList;
    }

    public List<String> FoodOnly() {
        List<String> retList = new ArrayList<>();
        for (MenuItem item : this.menu) {
            if (Objects.equals(item.type, "Food")) {
                retList.add(item.ItemName);
            }
        }
        return retList;
    }

    public void fulfillOrder() {
        if (!this.orders.isEmpty()) {
            System.out.println("The " + this.orders.get(0) + " is ready.");
            this.orders.remove(0);
        } else {
            System.out.println("There are no orders.");
        }
    }

    double findPrice(String item) {
        for (MenuItem menuItem : this.menu) {
            if (Objects.equals(menuItem.ItemName, item))
                return menuItem.price;
        }
        return 0;
    }

    boolean IsInMenu(String item) {
        for (MenuItem menuItem : this.menu)
            if (Objects.equals(menuItem.ItemName, item))
                return TRUE;

        return FALSE;
    }
}
