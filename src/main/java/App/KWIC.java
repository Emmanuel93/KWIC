package App;

import Framework.ConcreteClasses.*;

import java.io.IOException;
import java.util.ArrayList;

public class KWIC {

    private Lines lines = new Lines(new ArrayList<Line>());
    private Lines index = new Lines(new ArrayList<Line>());

    private Input input = new Input(new ReaderPDF("clean.pdf"));
    private Output output = new Output(new WriterPDF("output.pdf"));

    private Indexer indexer = new Indexer(index);
    private Alphabetizer alphabetizer = new Alphabetizer();

    public KWIC() {
        lines.addObserver(indexer);
        run();
    }

    private void run() {
        try {
            input.read(lines);
            output.write(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new KWIC();
    }
}
