package App;

import Framework.ConcreteClasses.Lines;
import Framework.interfaces.Reader;
import Framework.interfaces.Writer;
import java.io.IOException;

public class Input {

    private Reader reader;

    public Input( Reader reader ){
        this.reader = reader;

    }

    public void read(Lines lines) throws IOException {
        this.reader.read(lines);
    }

}
