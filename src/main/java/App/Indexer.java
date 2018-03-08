package App;


import Framework.ConcreteClasses.Line;
import Framework.ConcreteClasses.Lines;
import Framework.ConcreteClasses.LinesEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Indexer implements Observer {

    //private final String TEST = "stops_words.txt";
    private final String TEST = "stop_words.txt";
    File file;

    private Lines lines;

    public Lines getLines() {
        return lines;
    }

    public Indexer(Lines lines){
        this.lines = lines;
        file = new File(TEST);
    }

    @Override
    public void update(Observable o, Object arg1) {
        LinesEvent event = (LinesEvent) arg1;
        Line line = event.getLine();
        try {

            line = removePunctuationMarks(line);
            removeStopWords(line);
            lines.insert(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void removeStopWords( Line line ) throws IOException {
        List<String> noWords = Files.readAllLines(Paths.get(file.getName()));
        line.getWords().removeIf(word -> noWords.contains(word));
        line.getWords().removeIf(word -> noWords.contains(word));
    }

    private Line removePunctuationMarks( Line line ){
        ArrayList<String> result = new ArrayList();
        for ( String word:line.getWords() ) {
            String aux = word.replaceAll("[^a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]", "").toLowerCase();
            if(!aux.isEmpty() && aux.length()>3)
                result.add(aux);
        }
        return new Line(result,line.getNumberOfLine());
    }

}
