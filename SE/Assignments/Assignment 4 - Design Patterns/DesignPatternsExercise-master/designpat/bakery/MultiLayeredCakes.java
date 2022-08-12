package designpat.bakery;
/*
 * Group 77  Ankie Fan i6272224
 *            Yaonan Hu i6285725
 */
public class MultiLayeredCakes extends Components{
    Cake cake;

    MultiLayeredCakes(Cake cake){
        this.cake = cake;
    }
    @Override
    public int getCost() {
        return cake.getCost() + 5;
    }

    @Override
    public String getDescription() {
        return  "Multi-layered" + cake.getDescription();
    }

}
