package designpat.telephone;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observer;
/*
 * Group 77  Ankie Fan i6272224
 *            Yaonan Hu i6285725
 */
/**
 * Store a phone number, digit-by-digit
 */
public class PhoneModel {
    public interface Observer {
        void update();
    }

    private List<Observer> observers = new LinkedList<>();
    private List<Integer> digits = new ArrayList<>();

    public void addDigit(int newDigit) {
        digits.add(newDigit);
        notifyAllObservers();
    }

    public List<Integer> getDigits() {
        return digits;
    }

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void notifyAllObservers(){
        for(Observer o : observers){
            o.update();
        }
    }


}
