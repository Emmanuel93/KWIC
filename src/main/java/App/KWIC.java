package App;

import Framework.ConcreteClasses.*;

import java.io.IOException;
import java.util.ArrayList;

public class KWIC {

    private Lines lines = new Lines(new ArrayList<Line>());
    private Lines shifts = new Lines(new ArrayList<Line>());

    private Input input = new Input(new ReaderTextFile("input.txt"));
    private Output output = new Output(new WriterTextFile("output.txt"));

    private CircularShift circularShift = new CircularShift(shifts);
    private Alphabetizer alphabetizer = new Alphabetizer();

    public KWIC() {
        lines.addObserver(circularShift);
        shifts.addObserver(alphabetizer);
        run();
    }

    private void run() {
        try {
            input.read(lines);
            //input.readPDF(lines, new File("holy.pdf"));
            output.write(shifts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new KWIC();
    }
}
