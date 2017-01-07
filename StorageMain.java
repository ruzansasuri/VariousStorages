
/**
 * StorageMain.java
 * @author: Ghodratollah Aalipour
 * @author: Ruzan Sasuri
 * @author: Akash Venkatachalam
 * Version: $Id StorageMain.java, 10/03/2016$
 *
 * This class has the main function and two methods!
 */

import java.util.Scanner;


public class StorageMain
{
    /**
     * This function checks if our storage objects work properly or not?
     *
     * @param aStorage is a kind of storage
     */
    public void testAll(StorageInterface<Integer> aStorage) {
       aStorage.insert(4);
       aStorage.insert(5);
       aStorage.insert(6);
       aStorage.remove(4);
       System.out.println(aStorage.contain(4));
       aStorage.size();
       System.out.println("Our storage has size " + aStorage.size());
       System.out.println("\n");
       print(aStorage);
    }
    public static void print(StorageInterface<Integer> si)
    {
        for(int i = 0 ; i < si.size() ; i++ )
        {
            System.out.print(si.next() + " ");
        }
        System.out.print("\n");
        si.startAgain();
    }
    public static void main(String a[])
    {
        StorageInterface<Integer> so = new StorageOrder<Integer>() ;
        StorageInterface<Integer> sp = new StorageSpeed<Integer>() ;
        StorageInterface<Integer> se = new StorageSet<Integer>();
        new StorageMain().testAll(so);
        new StorageMain().testAll(se );
        new StorageMain().testAll(sp);
        so.addAll(se);
        System.out.println();
        print(so);
    }
}