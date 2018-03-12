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
        System.out.println("entro");
        FileWriter writer = new FileWriter(file);
        shifts.all().stream().map(Line::getNumberOfLine).distinct().forEachOrdered(line -> {
            try {
                writer.write(line+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.flush();
    }
}
