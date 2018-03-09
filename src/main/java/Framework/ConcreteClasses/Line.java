package Framework.ConcreteClasses;

import Framework.interfaces.Storable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line implements Storable,Comparable<Line> {

    private Integer numberOfLine;

    private List<String> words;

    public Line( List<String> words ) {
        this.words = new ArrayList<>();
        for (String word:words) {
            this.words.add(word);
        };
        this.numberOfLine = 0;
    }

    public Line( List<String> words, Integer numberOfLine ) {
        this.words = words;
        this.numberOfLine = numberOfLine;
    }

    public List<String> getWords() {
        return this.words;
    }

    @Override
    public String toString() {
        String result="";
        for ( String word: this.words ) {
            result+=word.toLowerCase()+" ";
        }

        return result+="";
    }

    @Override
    public int compareTo(Line o) {
        String line1 = o.getWords().stream().collect(Collectors.joining()).toLowerCase();
        String line2 = o.getWords().stream().collect(Collectors.joining()).toLowerCase();
        return line1.compareTo(line2);
    }
}
