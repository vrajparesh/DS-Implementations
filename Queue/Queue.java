package Queue;

import java.util.*;

public class Queue {
    protected Object[] queue;
    protected int size;
    protected int currentsize;

    public Queue(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException("array size should be greater than 0");
        queue = new Object[initialCapacity];
        currentsize = 0;
    }

    public Queue() {
        this(10);
    }

    void checkindex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Error");
    }

    public int size() {
        return size;
    }

    Object get(int index) {
        checkindex(index);
        return queue[index];
    }

    void add(int index, Object theElement) {
        checkindex(index);

        queue = Arrays.copyOf(queue, 2 * queue.length);

        for (int i = size - 1; i >= index; i--)
            queue[i + 1] = queue[i];

        queue[index] = theElement;
        size++;
        currentsize++;
    }

    Object remove() {

        Object removedElement = queue[size() - 1];
        size--;
        queue[size] = null;
        currentsize--;

        return removedElement;
    }

    public String toString() {
        StringBuffer s = new StringBuffer("[");
        for (int i = 0; i < currentsize; i++)
            if (queue[i] == null)
                s.append("null,");
            else
                s.append(queue[i].toString() + ",");

        if (size > 0)
            s.delete(s.length() - 1, s.length());
        s.append("]");

        return new String(s);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Queue a = new Queue();
        int ch, e;
        do {
            System.out.print("\n\n  1.Add \n  2.Remove \n  3.Display\n");
            System.out.print("\n  Enter your choice :: ");
            ch = sc.nextInt();

            switch (ch) {
            case 1:
                System.out.print("\n\n  Enter the number of elements you want to add : ");
                int d = sc.nextInt();
                int i = 0;
                System.out.print("\n\n  Enter the elements : ");
                while (i < d) {

                    a.add(0, sc.nextInt());
                    i++;
                }
                break;
            case 2:
                System.out.print("\n  Element removed " + a.remove());
                break;

            case 3:
                System.out.print("\n\n  The Array Linear List is :: ");
                System.out.print(a.toString());
                break;

            default:
                System.out.println("\n\n  WRONG CHOICE!!");
            }
            System.out.print("\n\n  Do you want to continue, if(yes) press 1 : ");
            e = sc.nextInt();

        } while (e == 1);
    sc.close();
    }
}