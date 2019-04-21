package BST;
import java .util.*;


public class BSTDriver extends BinarySearchTree {
	static Scanner sc=new Scanner(System.in);
	 public static int cont()
	 {  
		System.out.println("Do you want to continue? \n(1)Yes\n(0)No");
		
		 return sc.nextInt();
	 }
	 public static void main(String[] args) { 
	     BinarySearchTree tree = new BinarySearchTree(); 
	    
         while(cont()==1?true:false) {
        	 System.out.println("Enter your Choice \n1)Insert\n2)Delete\n3)Print Inorder\n4)Exit");
        	 switch(sc.nextInt())
        	 {
        	 	case 1: 
        	 		System.out.println("Enter no. of elements to enter");
        	 		   for(int i=sc.nextInt();i>0;i--)
        	 			tree.insert(sc.nextInt());
        	 			cont();
        	 			break;
        	 	case 2: tree.deleteKey(sc.nextInt());
        	 			cont();
        	 			break;
        	 	case 3: tree.inorder();
        	 			cont();
        	 			break;
        	 	case 4: return;
        	 	default: System.out.println("Wrong input");
        	 }
	    
         } 
	 }
}
