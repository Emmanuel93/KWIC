package Framework.ConcreteClasses;

import Framework.interfaces.Storable;

import java.util.ArrayList;
import java.util.List;

public class Line implements Storable,Comparable {

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

    public Integer getNumberOfLine() {
        return numberOfLine;
    }

    @Override
    public String toString() {
        String result="";
        for ( String word: this.words ) {
            result+=word+" ";
        }

        return result+="";
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }
}
