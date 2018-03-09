package App;

import Framework.ConcreteClasses.Line;
import Framework.ConcreteClasses.Lines;


import java.util.*;

public class Alphabetizer implements Observer {

    @Override
    public void update(Observable o, Object arg1) {
        List<Line> shifts = ((Lines) o).all();
        shifts.sort(Comparator.comparing(Line::toString));
        //shifts.sort(Comparator.comparing(String::toLowerCase));
    }
}

