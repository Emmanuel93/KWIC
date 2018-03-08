package App;

import Framework.ConcreteClasses.Line;
import Framework.ConcreteClasses.Lines;
import Framework.ConcreteClasses.LinesEvent;

import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

public class CircularShift implements Observer {

    private Lines shifts;

    public CircularShift(Lines shift) {
        this.shifts = shift;
    }

    @Override
    public void update(Observable o, Object arg) {
        LinesEvent event = (LinesEvent) arg;
        Line line = event.getLine();

        List<String> words = line.getWords();

        for (int i = 0; i < words.size(); ++i) {
            Collections.rotate(words, 1);
            Line aux = new Line(words);
            shifts.insert(aux);

        }
    }

    public Lines getShifts() {
        return shifts;
    }

    private String build(List<String> inc) {
        return inc.stream().map(word -> word.concat(" ")).collect(Collectors.joining());
    }

}