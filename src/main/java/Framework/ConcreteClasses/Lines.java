package Framework.ConcreteClasses;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Lines extends Observable{

    private List<String> lines = new ArrayList<>();

    public void insert(String line) {
        lines.add(line);
        setChanged();
        notifyObservers(new LinesEvent(line));
    }

    public void remove(int index) {
        lines.remove(index);
    }

    public String get(int index) {
        return lines.get(index);
    }

    public List<String> all(){
        return lines;
    }
}
