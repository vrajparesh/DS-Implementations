package RBT;

import java.util.Scanner;


public class RBTDriver
{
    public static void main(String[] args)
    {            
       Scanner sc = new Scanner(System.in);
       RBTree rbt = new RBTree(Integer.MIN_VALUE); 
       System.out.println("Red Black Tree Test\n");          
       char ch;
       do    
       {
           System.out.println("\nChoose the operation to perform\n");
           System.out.println("1. Insert ");
           System.out.println("2. Search");
           System.out.println("3. Count nodes");
           System.out.println("4. Check empty");
           System.out.println("5. Clear tree");

           int choice = sc.nextInt();            
           switch (choice)
           {
           case 1 : 
               System.out.println("Enter integer element to insert");
               rbt.insert( sc.nextInt() );                     
               break;                          
           case 2 : 
               System.out.println("Enter integer element to search");
               System.out.println("Search result : "+ rbt.search( sc.nextInt() ));
               break;                                          
           case 3 : 
               System.out.println("Nodes = "+ rbt.countNodes());
               break;     
           case 4 : 
               System.out.println("Empty status = "+ rbt.isEmpty());
               break;     
           case 5 : 
               System.out.println("\nTree Cleared");
               rbt.makeEmpty();
               break;         
           default : 
               System.out.println("Wrong Entry \n ");
               break;    
           }
           System.out.print("\nPost order : ");
           rbt.postorder();
           System.out.print("\nPre order : ");
           rbt.preorder();
           System.out.print("\nIn order : ");
           rbt.inorder(); 
           System.out.println("\nDo you want to continue (Type y or n) \n");
           ch = sc.next().charAt(0);                        
       } while (ch == 'Y'|| ch == 'y'); 
       sc.close();
    }  
}