
/**
 * StorageInterface.java
 * @author: Ghodratollah Aalipour
 * @author: Ruzan Sasuri
 * @author: Akash Venkatachalam
 * Version: $Id StorageInterface.java, 10/03/2016$
 *
 */

/**
 * This is our interface
 * @param <T>
 */
public interface StorageInterface<T>
{
    public void insert(T obj);
    public void remove(T obj);
    public boolean contain(T obj);
    public int size();
    public void addAll(StorageInterface<T> obj);
    public boolean hasNext();
    public T next();
    void startAgain();
}
