package designpat.telephone;
/*
 * Group 77  Ankie Fan i6272224
 *            Yaonan Hu i6285725
 */
/**
 * Prints things out to the screen, when needed
 * Printing to the screen:
 * System.out.println("hello");
 */
public class Screen {

    private final PhoneModel model;


    public Screen(PhoneModel model) {
        this.model = model;
        model.addObserver(new PhoneModel.Observer() {
            @Override
            public void update() {
                System.out.println(model.getDigits().get(model.getDigits().size()-1));
            }
        });

        model.addObserver(new PhoneModel.Observer() {
            @Override
            public void update() {
                if(model.getDigits().size() == 10) {
                    StringBuilder out = new StringBuilder();
                    for (int i = 0; i < 10; i++) {
                        out.append(model.getDigits().get(i));
                    }
                    System.out.println("Now dialing " + out +"...");
                }
            }
        });

    }



}
