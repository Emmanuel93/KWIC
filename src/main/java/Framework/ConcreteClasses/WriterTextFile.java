package Framework.ConcreteClasses;

import Framework.AbstractClasses.AbstractWriter;

public class WriterTextFile extends AbstractWriter {

    private String path;

    public WriterTextFile(String path){
        this.path = path;
    }

    @Override
    public void write() {
        System.out.println("Escribi en el pdf"+this.path);
    }
}
