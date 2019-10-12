package Stack;

import java.util.*;

public class Stack {
    protected Object[] stack;
    protected int size;
    protected int currentsize;

    public Stack(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException("array size should be greater than 0");
        stack = new Object[initialCapacity];
        currentsize = 0;
    }

    public Stack() {
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
        return stack[index];
    }

    void push(int index, Object theElement) {
        checkindex(index);
        if (index == stack.length)
            stack = Arrays.copyOf(stack, 2 * stack.length);

        for (int i = size - 1; i >= index; i--)
            stack[i + 1] = stack[i];
        stack[index] = theElement;
        size++;
        currentsize++;
    }

    Object pop(int index) {
        checkindex(index);
        Object removedElement = stack[index];

        for (int i = index + 1; i < size; i++)
            stack[i - 1] = stack[i];
        size--;
        stack[size] = null;
        currentsize--;

        return removedElement;
    }

    public String toString() {
        StringBuffer s = new StringBuffer("[");
        for (int i = 0; i < currentsize; i++)
            if (stack[i] == null)
                s.append("null,");
            else
                s.append(stack[i].toString() + ",");

        if (size > 0)
            s.delete(s.length() - 1, s.length());
        s.append("]");

        return new String(s);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Stack a = new Stack();
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

                    a.push(a.size(), sc.nextInt());
                    i++;
                }
                break;
            case 2:
                System.out.print("\n  Element removed " + a.pop(a.size() - 1));
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