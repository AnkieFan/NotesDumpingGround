package designpat.bakery;
/*
 * Group 77  Ankie Fan i6272224
 *            Yaonan Hu i6285725
 */
public class StrawberryCake implements Cake{
    @Override
    public int getCost() {
        return 2*CAKE_COST;
    }

    @Override
    public String getDescription() {
        return "Strawberry cake";
    }
}
