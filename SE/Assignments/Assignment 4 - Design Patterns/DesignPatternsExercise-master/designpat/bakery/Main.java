package designpat.bakery;
/*
 * Group 77  Ankie Fan i6272224
 *            Yaonan Hu i6285725
 */
/**
 * Create an order and print it
 */
public class Main {
    public static void main(String[] args) {
        // Create the order
        Order order = new Order();

        Cake first = new ChocolateCake();
        order.addCake(first);


        Cake second = new VanillaCake();
        second = new SayingX(second,"PLAIN");
        order.addCake(second);


        Cake third = new VanillaCake();
        third = new Sprinkles(third);
        third = new SayingX(third, "FANCY!");
        order.addCake(third);


        Cake fourth = new StrawberryCake();
        fourth = new MultiLayeredCakes(fourth);
        fourth = new Sprinkles(fourth);
        fourth = new Sprinkles(fourth);
        fourth = new SayingX(fourth,"One of");
        fourth = new SayingX(fourth, "EVERYTHING");
        order.addCake(fourth);


        // Print the order
        order.printOrder();
    }
}
