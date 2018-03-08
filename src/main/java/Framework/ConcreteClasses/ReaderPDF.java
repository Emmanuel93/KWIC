package Framework.ConcreteClasses;

import Framework.AbstractClasses.AbstractReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReaderPDF extends AbstractReader {

    private String path;
    private File file;

    public ReaderPDF(String path){
        this.path = path;
        file = new File(path);

    }

    @Override
    public void read(Lines lines) {
       /*System.out.println("hola mundo lei un PDF");
        try {
            Files.readAllLines(Paths.get(file.getName())).forEach(line -> lines.insert(new Line(line.)));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
