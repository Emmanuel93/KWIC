package Framework.AbstractClasses;

import Framework.interfaces.Storable;
import Framework.interfaces.Storage;

import java.util.List;
import java.util.Observable;

public abstract class AbstractStorageObservable<E extends Storable> extends Observable implements Storage<E>{

    protected List<E> lines;

    protected AbstractStorageObservable( List<E> lines ){
        this.lines = lines;
    }

    @Override
    public abstract List<E> all();

    @Override
    public abstract void insert(E line);

    @Override
    public abstract E get(Integer index);

    @Override
    public abstract void remove(Integer index);

    @Override
    public abstract void update(Integer index, E obj) throws Exception;
}
