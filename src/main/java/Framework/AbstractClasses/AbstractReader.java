package Framework.AbstractClasses;

import Framework.ConcreteClasses.Lines;
import Framework.interfaces.Reader;

import java.io.IOException;
import java.util.ArrayList;

public abstract class AbstractReader implements Reader {

    protected AbstractReader(){

    }

    public abstract void read(Lines lines) throws IOException;


}

