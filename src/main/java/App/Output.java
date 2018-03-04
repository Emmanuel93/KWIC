package App;

import Framework.ConcreteClasses.Lines;
import Framework.interfaces.Writer;

import java.io.IOException;

public class Output {

    private Writer writer;

    public Output (Writer writer){
        this.writer = writer;
    }
    @SuppressWarnings("resource")
    public void write(Lines shifts) throws IOException{
        writer.write(shifts);
    }
}
