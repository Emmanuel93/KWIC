package Framework.ConcreteClasses;
import Framework.AbstractClasses.AbstractStorageObservable;

import java.util.List;


public class Lines extends AbstractStorageObservable<Line> {


    public Lines(List<Line> lines) {
        super(lines);
    }

    @Override
    public List<Line> all() {
        return this.lines;
    }

    @Override
    public void insert(Line line) {
        lines.add(line);
        setChanged();
        notifyObservers(new LinesEvent(line));
    }

    @Override
    public Line get(Integer index) {
        return this.lines.get(index);
    }

    @Override
    public void remove(Integer index) {
        this.lines.remove(index);
    }

    @Override
    public void update(Integer index, Line obj) throws Exception {
        throw new Exception("no soportada aun!");
    }
}
