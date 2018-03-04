package Framework.ConcreteClasses;

import Framework.AbstractClasses.AbstractWriter;

public class WriterPDF extends AbstractWriter{

    private String path;

    private WriterPDF( String path ) {
        this.path = path;
    }

    @Override
    public void write(Lines lines) {
        System.out.println("Escribi en el pdf"+this.path);
    }
}
