package App;

import Framework.ConcreteClasses.Lines;

import java.util.Comparator;
import java.util.Observable;
import java.util.Observer;

public class Alphabetizer implements Observer {

    @Override
    public void update(Observable o, Object arg1) {
        Lines shifts = (Lines) o;
        shifts.all().sort(Comparator.comparing(String::toLowerCase));
    }
}

