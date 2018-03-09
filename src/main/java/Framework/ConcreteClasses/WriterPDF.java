package Framework.ConcreteClasses;

import Framework.AbstractClasses.AbstractWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class WriterPDF extends AbstractWriter{

    private String path;

    private final Integer FONTSIZE = 10;
    private final Integer MOVEMENT = -FONTSIZE - 2;
    private Integer CURSORPOSITION = 0;
    private File file;


    public WriterPDF( String path ) {
        this.path = path;
        this.file = new File(path);
    }

    @Override
    public void write(Lines lines) throws IOException {
        HashMap<String,String> test = new HashMap<>();
        for (Line aux: lines.all()){
            for(String word: aux.getWords()){
                if( !test.containsKey(aux.getNumberOfLine())){
                    test.put(aux.getNumberOfLine()+"",word);
                }else{
                    test.replace(test.get(word)+","+aux.getNumberOfLine()+"",word);
                }

            }
        }

        System.out.println(test);

        FileWriter writer = new FileWriter(file);
        Map<String, List<String>> result =  test.entrySet().stream().collect(Collectors.groupingBy(
                Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        writePDF(result);

    }

    private void writePDF( Map<String, List<String>> index) {

        try {
            PDDocument doc;
            doc = new PDDocument();
            PDPage page = new PDPage();
            CURSORPOSITION = 700;
            doc.addPage(page);
            PDFont font = PDType1Font.COURIER_BOLD_OBLIQUE;
            Color color = Color.BLACK;
            PDPageContentStream contentStream = new PDPageContentStream(doc, page);
            contentStream.beginText();
            contentStream.setFont(font, FONTSIZE);
            contentStream.setNonStrokingColor(color);
            contentStream.newLineAtOffset(25, CURSORPOSITION + FONTSIZE + 2);

            for (Map.Entry<String, List<String>> line : index.entrySet()) {

                if (CURSORPOSITION < 100) {
                    CURSORPOSITION = 700;

                    contentStream.endText();
                    contentStream.close();
                    page = new PDPage();
                    doc.addPage(page);

                    contentStream = new PDPageContentStream(doc, page);
                    contentStream.setFont(font, FONTSIZE);
                    contentStream.beginText();
                    contentStream.newLineAtOffset(25, CURSORPOSITION + FONTSIZE + 2);
                }
                contentStream.newLineAtOffset(0, MOVEMENT);
                CURSORPOSITION = CURSORPOSITION + MOVEMENT;
                contentStream.showText(line.getKey() + " " + line.getValue().toString());
            }

            contentStream.setNonStrokingColor(Color.BLACK);
            contentStream.endText();
            contentStream.close();
            doc.save(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
