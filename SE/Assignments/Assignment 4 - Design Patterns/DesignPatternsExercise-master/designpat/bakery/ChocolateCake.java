package designpat.bakery;
/*
 * Group 77  Ankie Fan i6272224
 *            Yaonan Hu i6285725
 */
public class ChocolateCake implements Cake {
    @Override
    public int getCost() {
        return CAKE_COST;
    }

    @Override
    public String getDescription() {
        return "Chocolate cake";
    }
}
