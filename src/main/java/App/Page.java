package App;

import App.Line;

import java.util.List;

public class Page {

    private Integer numberOfPage;

    private List<Line> lines;

    public Page( List<Line> lines ){
        this.lines = lines;
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public Integer getNumberOfPage() {
        return this.numberOfPage;
    }
}
