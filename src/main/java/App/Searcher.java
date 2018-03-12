package App;

import Framework.ConcreteClasses.Line;
import Framework.ConcreteClasses.Lines;
import Framework.ConcreteClasses.LinesEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Searcher implements Observer {

    //private final String TEST = "stops_words.txt";
    private final String TEST = "search_word.txt";
    File file;

    private Lines lines;

    public Lines getLines() {
        return lines;
    }

    public Searcher(Lines lines){
        this.lines = lines;
        file = new File(TEST);
    }

    @Override
    public void update(Observable o, Object arg1) {
        try {
            List<String> searchWords = Files.readAllLines(Paths.get(file.getName()));
            LinesEvent event = (LinesEvent) arg1;
            Line line = event.getLine();

            searchWords.stream()
                    .forEach(obj ->{

                        String linea =  line.toString().toLowerCase();
                        if(linea.contains(obj.toLowerCase())){
                            lines.insert(new Line( Arrays.asList( obj.toLowerCase() ), line.getNumberOfLine() ) );
                        }
                        /*line.getWords().stream()
                                .forEach( aux ->{
                                    if(obj.equals(aux)){
                                        lines.insert( new Line(Arrays.asList(aux),line.getNumberOfLine()));
                                    }
                                });*/
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}