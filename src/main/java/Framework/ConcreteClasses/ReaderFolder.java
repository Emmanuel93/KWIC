package Framework.ConcreteClasses;

import Framework.AbstractClasses.AbstractReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReaderFolder extends AbstractReader {


    private String path;
    private File file;

    public ReaderFolder(String path){
        this.path = path;
        file = new File(path);

    }
    @Override
    public void read(Lines lines) throws IOException {

        try (Stream<Path> paths = Files.walk(Paths.get(""))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(file->{
                        //System.out.println(file.getFileName().toString());
                        lines.insert( new Line(Arrays.asList( file.getFileName().toString())) );
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
