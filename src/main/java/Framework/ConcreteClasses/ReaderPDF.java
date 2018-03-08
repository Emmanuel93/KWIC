package Framework.ConcreteClasses;

import Framework.AbstractClasses.AbstractReader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReaderPDF extends AbstractReader {

    private String path;
    private File file;

    public ReaderPDF(String path){
        this.path = path;
        file = new File(path);

    }

    @Override
    public void read(Lines lines) throws IOException {
        PDDocument document = PDDocument.load(file);
        PDFTextStripper stripper = null;
        for (int i = 0; i < document.getNumberOfPages(); i++) {
            stripper = new PDFTextStripper();
            stripper.setStartPage(i);
            stripper.setEndPage(i);
            String pageText = stripper.getText(document);
            //lines of pages
            ArrayList<String> page = Arrays.stream(pageText.split("\\n"))
                    .collect(Collectors.toCollection(ArrayList::new));

            for (String line : page) {

                ArrayList<String> words = Arrays.stream(line.split(" "))
                        .collect(Collectors.toCollection(ArrayList::new));

                lines.insert(new Line(words, (i + 1)));

            }
        }
        document.close();
    }
}
