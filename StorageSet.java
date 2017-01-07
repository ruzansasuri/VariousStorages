

/**
 * StorageSet.java
 *
 *  This class generate a storage which preserves the order of insertion
 *
 * @author: Ghodratollah Aalipour
 * @author: Ruzan Sasuri
 * @author: Akash Venkatachalam
 * Version: $Id StorageSet.java, 10/03/2016$
 *
 */
public class StorageSet<T extends Comparable<T>> implements StorageInterface<T>
{
    private Node<T> head;
    private Node<T> traverse;
    public StorageSet()
    {
        head = null;
        traverse = head;
    }

    /**
     *
     * @param val the object we want to insert in our storage
     */
    public void insert(T val)
    {
        if(head == null)
        {
            head = new Node<T>(val);
            traverse = head;
        }
        else
        {
            Node<T> trav = head;
            while(trav.hasNext())
            {
                if(trav.getValue().equals(val))
                {
                    return;
                }
                trav = trav.getNext();
            }
            if(!trav.getValue().equals(val))
            {
                trav.setNext(new Node<T>(val));
            }
        }
    }

    /**
     *
     * @param obj The object we want to remove from the list
     */

    public void remove(T obj)
    {
        Node<T> trav = head;
        if(trav.getValue().equals(obj))
        {
            System.out.println("Found obj: "+obj);
            head = trav.getNext();
        }
        else
        {
            while (trav.hasNext())
            {
                Node<T> next = trav.getNext();
                if (next.getValue().equals(obj))
                {
                    System.out.println("Found obj: " + obj);
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
     *
     * @param obj The object we want to check if it is present in the list or not?
     * @return true or false as the result of presence
     */
    public boolean contain(T obj)
    {
        Node<T> trav = head;
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

    /**
     *
     * @return The size of our list
     */
    public int size()
    {
        if(head == null)
        {
            return 0;
        }
        Node<T> trav = head;
        int n = 0;
        while(trav != null)
        {
            n++;
            trav = trav.getNext();
        }
        return n;
    }
    /**
     *
     * @return the thoer node pointed by current node
     */
    public Node<T> getHead()
        {
            return this.head;
        }

    /**
     *
     * @param obj The list we want to add to our current list
     */
    public void addAll(StorageInterface<T> obj)
    {
        for(int i = 1; i <= obj.size(); i++)
        {
            insert(obj.next());
        }
    }

    /**
     * Restarts the process of traveling
     */
    public void startAgain()
    {
        traverse = head;
    }

    /**
     *
     * @return true or false upon excistance of at least an element in our list
     */
    public boolean hasNext()
    {
        if(traverse == null)
        {
            return false;
        }
        return traverse.hasNext();
    }

    /**
     *
     * @return The value of the next node
     */
    public T next()
    {
        T t = traverse.getValue();
        traverse = traverse.getNext();
        return t;
    }
    public static void main(String ag[])
    {
        StorageSet<Integer> s = new StorageSet<Integer>();
        s.insert(2);
        s.insert(3567);
        s.insert(123);
        s.insert(123);
        s.insert(622);
        System.out.println(s.size());
        s.remove(3567);
        System.out.println(s.size());
        System.out.println(s.contain(123));
        System.out.println(s.contain(3567));
        if(s.size() == 0)
        {
            System.out.println("No objects");
        }
        else
        {
            for (int i = 1; i <= s.size(); i++)
            {
                System.out.println(i + ". "  + s.next());
            }
        }
    }
}
