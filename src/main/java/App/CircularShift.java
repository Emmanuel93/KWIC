package App;


import Framework.ConcreteClasses.Lines;
import Framework.ConcreteClasses.LinesEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
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

        List<String> result = new LinkedList<>();
        List<String> words = new ArrayList<>(Arrays.asList(event.getLine().split("\\s")));

        for (int i = 0; i < words.size(); ++i) {
            Collections.rotate(words, 1);
            result.add(build(words));
        }

        result.stream().forEach(line -> shifts.insert(line));
    }

    private String build(List<String> inc) {
        return inc.stream().map(word -> word.concat(" ")).collect(Collectors.joining());
    }

}