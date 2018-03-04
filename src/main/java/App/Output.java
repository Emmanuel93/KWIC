package App;

import Framework.ConcreteClasses.Lines;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Output {

    @SuppressWarnings("resource")
    public void write(Lines shifts, File file) throws IOException{
        FileWriter writter = new FileWriter(file);
        shifts.all().stream().distinct().forEachOrdered(line -> {
            try {
                writter.write(line+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writter.flush();
    }
}
