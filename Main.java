import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Coffeehouse c = new Coffeehouse();
        c.addOrder("Lemonade");
        c.addOrder("Sandwich");

        System.out.println(c.cheapestItem());
    }
}


