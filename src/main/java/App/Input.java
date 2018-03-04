package App;

import Framework.ConcreteClasses.Lines;
import Framework.interfaces.Reader;
import Framework.interfaces.Writer;
import java.io.IOException;

public class Input {

    private Reader reader;

    private Writer writer;

    public Input( Reader reader, Writer writer){
        this.reader = reader;
        this.writer = writer;

    }

    public void read(Lines lines) throws IOException {
        this.reader.read(lines);
    }

}
