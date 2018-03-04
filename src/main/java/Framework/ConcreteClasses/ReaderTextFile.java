package Framework.ConcreteClasses;

import Framework.AbstractClasses.AbstractReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReaderTextFile extends AbstractReader {

    private String path;
    private File file;

    public ReaderTextFile(String path){
        this.path = path;
        file = new File(path);

    }

    @Override
    public void read(Lines lines) throws IOException {
        System.out.println("Text file leido"+ this.path);

        Files.readAllLines(Paths.get(file.getName())).forEach(line -> lines.insert(line));

    }
}
