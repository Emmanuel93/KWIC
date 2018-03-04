package Framework.AbstractClasses;

import Framework.ConcreteClasses.Lines;
import Framework.interfaces.Writer;

import java.io.IOException;

public abstract class AbstractWriter implements Writer{

    public abstract void write(Lines lines) throws IOException;
}
