package Framework.interfaces;

import java.util.List;

public interface Storage<E extends Storable> {

    public List<E> all();

    public void insert(E line);

    public E get(Integer index);

    public void remove(Integer index);

    public void update(Integer index, E obj ) throws Exception;

}
