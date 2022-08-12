package designpat.bakery;
/*
 * Group 77  Ankie Fan i6272224
 *            Yaonan Hu i6285725
 */
public class SayingX extends Components{
    Cake cake;
    String x;

    SayingX(Cake cake, String toSay){
        this.cake = cake;
        x = toSay;
    }
    @Override
    public int getCost() {
        return cake.getCost();
    }

    @Override
    public String getDescription() {
        return cake.getDescription() + " with saying \"" + x +"\"";
    }


}
