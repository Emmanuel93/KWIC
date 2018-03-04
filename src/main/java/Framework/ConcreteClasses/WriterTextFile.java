package Framework.ConcreteClasses;

import Framework.AbstractClasses.AbstractWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterTextFile extends AbstractWriter {

    private String path;
    private File file;

    public WriterTextFile(String path){
        this.path = path;
        this.file = new File(path);
    }

    @Override
    public void write(Lines shifts) throws IOException {
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
