/***
 * StorageSpeed.java
 * @author Ruzan Sasuri rps7183@g.rit.edu
 * @author Ghodratollah Aalipour ga5481@g.rit.edu
 * @author Akash Venkatachalam av2833@g.rit.edu
 *
 * Id: "$StorageSpeed.java v1.0 2016/10/3"
 * Revision: First Revision.
 *
 * Creates a storage class that stores and returns field using a hash map.
 * @param <T> Generic used.
 */
public class StorageSpeed<T> implements StorageInterface<T>
{
    private Node<T> arr[]; // Array containing the hash map.
    private int ti; // Current index being traversed by the hasNext or next function.
    private Node<T> traverse; // Current node of the index being traversed.
    private int start;// The starting index.
    /**
     * Non-parametrized constructor that initialize the array to a size of 100.
     */
    @SuppressWarnings("unchecked")
    public StorageSpeed()
    {
        traverse = new Node<T>();
        arr = (Node<T>[])java.lang.reflect.Array.newInstance(traverse.getClass(), 100);
        start = -1;
        ti = 0;
        traverse = null;
    }

    /**
     * Returns the index where the object needs to be stored or is stored in the hash map.
     * @param hash the hashcode of the object.
     * @return i, the index in the hashmap where the object will be stored.
     */
    public int indexFinder(int hash)
    {
        int i = hash * 3;
        i %= arr.length;
        return i;
    }

    /**
     * Inserts an object into the storage.
     * @param obj The obect to be stored.
     */
    public void insert(T obj)
    {
        int index = indexFinder(obj.hashCode());//The index of the hashmap where the object will be stored.
        if(arr[index] == null)
        {
            arr[index] = new Node<T>(obj);
            if(start == -1)
            {
                ti = index;
                start = index;
                traverse = arr[ti];
            }
        }
        else
        {
            Node<T> trav = arr[index];
            while(trav.getNext() != null)
            {
                trav = trav.getNext();
            }
            trav.setNext(new Node<T>(obj));
        }
    }

    /**
     * Removes the object from the hashmap if it exists and prints it.
     * @param obj The object to be removes
     */
    public void remove(T obj)
    {
        int index = indexFinder(obj.hashCode());
        if(arr[index] == null)
        {
            System.out.println(obj + " not found");
        }
        else
        {
            Node<T> trav = arr[index];
            if(trav.getValue().equals(obj))
            {
                System.out.println("Found obj: "+obj);
                arr[index] = trav.getNext();
                return;
            }
            while(trav.getNext() != null)
            {
                Node<T> next = trav.getNext();
                if(next.getValue().equals(obj))
                {
                    System.out.println("Found obj: "+obj);
                    trav.setNext(next.getNext());
                    trav = null;
                    break;
                }
                trav = next;
            }
            if(trav == null)
            {
                System.out.println("Obj " + obj + " not found");
            }
        }
    }

    /**
     * Checks if the storage contains a particular object.
     * @param obj
     * @return true, if the object is in the hashmap, and false, if the object is not in the hashmap.
     */
    public boolean contain(T obj)
    {
        int index = indexFinder(obj.hashCode());
        if(arr[index] == null)
        {
            return false;
        }
        else
        {
            Node<T> trav = arr[index];
            if(trav.getValue().equals(obj))
            {
                return true;
            }
            while(trav.getNext() != null)
            {
                Node<T> next = trav.getNext();
                if(next.getValue().equals(obj))
                {
                    return true;
                }
                trav = next;
            }
            return false;
        }
    }

    /**
     * Returns the number of elements in the hash map.
     * @return n, The number of elements in the hash map.
     */
    public int size()
    {
        int n = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] != null)
            {
                Node<T> trav = arr[i];
                while (trav != null)
                {
                    n++;
                    trav = trav.getNext();
                }
            }
        }
        return n;
    }

    /**
     * Adds all the objects from another storage into this one.
     * @param obj The storage object to be added.
     */
    public void addAll(StorageInterface<T> obj)
    {
        for(int i = 1; i <= obj.size(); i++)
        {
            insert(obj.next());
        }
    }

    /**
     * Sets the iterating index to the starting index.
     */
    public void startAgain()
    {
        ti = start;

    }

    /**
     * Checks if an element follows the current element traverse.
     * @return True, if there is a next element. False if there isn't.
     */
    public boolean hasNext()
    {
        if(start == -1)
        {
            return false;
        }
        int i = ti;
        boolean next = false;
        Node<T> tr = traverse;
        if(tr == null)
        {
            return false;
        }
        else if(tr.getNext() == null)
        {
            i++;
            tr = arr[i];
        }
        else
        {
            return true;
        }
        do
        {
            if(tr != null)
            {
                next = true;
                break;
            }
            i = (i + 1) % arr.length;
            tr = arr[i];
        }while(i != ti);
        if(arr[i] != null && arr[i] != tr)
        {
            next = true;
        }
        return next;
    }

    /**
     * Returns the next element in the storage if one exists.
     * @return The next object in the storage if it exists, else returns null.
     */
    public T next()
    {
        if(start == -1)
        {
            return null;
        }
        int i = ti;
        boolean next = false;
        if(traverse.getNext() == null)
        {
            i++;
            traverse = arr[i];
        }
        else
        {
            traverse = traverse.getNext();
            T t = traverse.getValue();
            return t;
        }
        do
        {
            if(traverse != null)
            {
                T t = traverse.getValue();
                ti = i;
                return t;
            }
            i = (i + 1) % arr.length;
            traverse = arr[i];
        }while(i != ti);
        if(arr[i] != null && arr[i] != traverse)
        {
            T t = traverse.getValue();
            return t;
        }
        else
        {
            return null;
        }
    }

    /**
     * The main method.
     * @param ag Not used.
     */
    public static void main(String ag[])
    {
        StorageOrder<Integer> s = new StorageOrder<Integer>();
        s.insert(2);
        s.insert(3567);
        s.insert(123);
        s.insert(434);
        s.insert(622);
        System.out.println(s.size());
        if(s.size() == 0)
        {
            System.out.println("No objects");
        }
        for(int i = 0; i < s.size(); i++)
        {
            System.out.println(s.next());
        }
        StorageSpeed<Integer> s1 = new StorageSpeed<Integer>();
        s.startAgain();
        s1.addAll(s);
        System.out.println();
        System.out.println(s.size());
        if(s1.size() == 0)
        {
            System.out.println("No objects");
        }
        for(int i = 0; i < s1.size(); i++)
        {
            System.out.println(s1.next());
        }
    }
}
