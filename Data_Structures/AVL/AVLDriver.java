package AVL;

import static AVL.AVLTree.Root;
import java.util.*;
public class AVLDriver {
    public static int cont()
	 {  Scanner sc=new Scanner(System.in);
		System.out.println("Do you want to continue? \n(!0)Yes\n(0)No");
		
		 return sc.nextInt();
		
	 }
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Scanner sc=new Scanner(System.in);
        while(cont()!=0?true:false)
        {
        System.out.println("Select your choice\n");
        System.out.println("1.Insert\n2.Delete\n3.Print PreOrder\n4.Print InOrder\n5.Exit");
        switch(sc.nextInt())
    {
       case 1:  System.out.println("Enter number of elements to be inserted");
       			int n=sc.nextInt();
    	   		for(int i=0;i<n;i++)
                {tree.add(sc.nextInt());}
                break;
        case 2: System.out.println("Enter the element to delete");
                tree.delete(sc.nextInt()); 
                break;
         
        case 3:  tree.showingPreOrder(Root);       
                    break;
        
        case 4: tree.showingInOrder(Root);            
                    break;
        case 5: System.exit(0);
     }
        
 }sc.close();
}
}