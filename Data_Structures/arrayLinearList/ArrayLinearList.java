package arrayLinearList;

import java.util.*;

public class ArrayLinearList implements LinearList 
{
	protected Object[] elements;
	protected static int size=0;
	public ArrayLinearList(int initialCapacity)
	{	
		if(initialCapacity<1)
			throw new IllegalArgumentException("Initial Capacity should be >=1 ");
		else
			elements=new Object[initialCapacity];
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	public void ChangeArrayLength()
	{
		elements=Arrays.copyOf(elements, size*2);
	}
	public void checkIndex(int index)
	{
		if(index<0||index>size)
			throw new IndexOutOfBoundsException("index:"+index+"size"+size);
	}
	public void add(int index,Object theElement)
	{
		checkIndex(index);
		if(size==elements.length)
			ChangeArrayLength();
		for(int i=size-1;i>=index;i--)
		{
			elements[i+1]=elements[i];
		}
		elements[index]=theElement;
		size++;
	}
	
	public Object remove(int index)
	{
		if(isEmpty())
		       throw new ArrayIndexOutOfBoundsException("Empty"); 
		checkIndex(index);
		Object relem=elements[index];
		for(int i=index;i<size-1;i++)
		{
			elements[i]=elements[i+1];
		}
		size--;
		elements[size]=null;
		return relem;
	}
	public void print(int size)
	{
		for(int i=0;i<size;i++)
		{
			System.out.println(elements[i]);
		}
	}
	
	public static void menu(ArrayLinearList element,int size)
	{   Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice: \n1)Add Element\n2)Remove Element\n3)Print Array\n4)Exit");
		switch(sc.nextInt())
		{
			case 1: 
				System.out.println("Enter the element to be added and its position");
				Object m=sc.next();
				int index=sc.nextInt();
				element.add(index,m);
				menu(element,size);
				break;
			case 2:	
				System.out.println("Enter the index to be removed");
				int i=sc.nextInt();
				element.remove(i);
				menu(element,size);
				break;
			case 3:
				element.print(size);
				menu(element,size);
				break;
			case 4:
				System.exit(0);
		}
		sc.close();
	}
	public static void main(String[] args)
	{   
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of ArrayList");
		size=sc.nextInt();				
		ArrayLinearList all=new ArrayLinearList(size);
		menu(all,size);
				
		sc.close();
	}
}
