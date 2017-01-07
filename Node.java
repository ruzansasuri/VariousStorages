/***
 * Node.java
 * @author Ruzan Sasuri rps7183@g.rit.edu
 * @author Ghodratollah Aalipour ga5481@g.rit.edu
 * @author Akash Venkatachalam av2833@g.rit.edu
 *
 * Id: "$Node.java v1.0 2016/10/3"
 * Revision: First Revision.
 *
 * The class to impllement a node in linked list.
 * @param <T> Generic used.
 */

public class Node<T>
{
    private T value;
    private Node<T> next;
    /**
     * Non-parametrized constructor to set next to null.
     */
    public Node()
    {
        next = null;
    }

    /**
     * Parametrized constructor to set the node's value and next to null.
     * @param val The value of the node.
     */
    public Node(T val)
    {
        value = val;
        next = null;
    }

    /**
     * Parametrized constructor to set the node's value and next.
     * @param val The value of the node.
     * @param n The next node.
     */
    public Node(T val, Node<T> n)
    {
        value = val;
        next = n;
    }

    /**
     * Checks if the current node has a node after it.
     * @return True if a node exists ahead  of it, false if it does not.
     */
    public boolean hasNext()
    {
        if(next != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Setter function for value.
     * @param v Value of the node.
     */
    public void setValue(T v)
    {
        value = v;
    }

    /**
     * Setter function for the next node.
     * @param n The next node.
     */
    public void setNext(Node<T> n)
    {
        next = n;
    }

    /**
     * Getter function for the value.
     * @return The node's value.
     */
    public T getValue()
    {
        return value;
    }

    /**
     * Getter function for the next node.
     * @return The node's next node.
     */
    public Node<T> getNext()
    {
        return next;
    }
}
