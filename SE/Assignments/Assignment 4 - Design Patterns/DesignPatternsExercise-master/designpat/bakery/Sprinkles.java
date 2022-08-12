package designpat.bakery;
/*
 * Group 77  Ankie Fan i6272224
 *            Yaonan Hu i6285725
 */
public class Sprinkles extends Components {
    Cake cake;

    Sprinkles(Cake cake){
        this.cake = cake;
    }
    @Override
    public int getCost() {
        return cake.getCost() + 2;
    }

    @Override
    public String getDescription() {
        return cake.getDescription() + " with sprinkles" ;
    }


}
