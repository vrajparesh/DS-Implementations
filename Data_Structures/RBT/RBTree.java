package RBT;
 class RBTree
 {
     private RBNode current;
     private RBNode parent;
     private RBNode grand;
     private RBNode great;
     private RBNode header;    
     private static RBNode temp;
     static 
     {
         temp = new RBNode(0);
         temp.left = temp;
         temp.right = temp;
     }
     static final int BLACK = 1;    
     static final int RED   = 0;
     public RBTree(int negInf)
     {
         header = new RBNode(negInf);
         header.left = temp;
         header.right = temp;
     }
     public boolean isEmpty()
     {
         return header.right == temp;
     }
     public void makeEmpty()
     {
         header.right = temp;
     }
     public void insert(int item )
     {
         current = parent = grand = header;
         temp.element = item;
         while (current.element != item)
         {            
             great = grand; 
             grand = parent; 
             parent = current;
             current = item < current.element ? current.left : current.right;          
             if (current.left.color == RED && current.right.color == RED)
                 handleReorient( item );
         }
         if (current != temp)
             return;
         current = new RBNode(item, temp, temp);
         if (item < parent.element)
             parent.left = current;
         else
             parent.right = current;        
         handleReorient( item );
     }
     private void handleReorient(int item)
     {
         current.color = RED;
         current.left.color = BLACK;
         current.right.color = BLACK;
 
         if (parent.color == RED)   
         {
             grand.color = RED;
             if (item < grand.element != item < parent.element)
                 parent = rotate( item, grand );
             current = rotate(item, great );
             current.color = BLACK;
         }
         header.right.color = BLACK; 
     }      
     private RBNode rotate(int item, RBNode parent)
     {
         if(item < parent.element)
             return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;  
         else
             return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);  
     }
     private RBNode rotateWithLeftChild(RBNode k2)
     {
         RBNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         return k1;
     }
     private RBNode rotateWithRightChild(RBNode k1)
     {
         RBNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         return k2;
     }
     public int countNodes()
     {
         return countNodes(header.right);
     }
     private int countNodes(RBNode r)
     {
         if (r == temp)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     public boolean search(int val)
     {
         return search(header.right, val);
     }
     private boolean search(RBNode r, int val)
     {
         boolean found = false;
         while ((r != temp) && !found)
         {
             int rval = r.element;
             if (val < rval)
                 r = r.left;
             else if (val > rval)
                 r = r.right;
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     public void inorder()
     {
         inorder(header.right);
     }
     private void inorder(RBNode r)
     {
         if (r != temp)
         {
             inorder(r.left);
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
             inorder(r.right);
         }
     }
     public void preorder()
     {
         preorder(header.right);
     }
     private void preorder(RBNode r)
     {
         if (r != temp)
         {
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
     public void postorder()
     {
         postorder(header.right);
     }
     private void postorder(RBNode r)
     {
         if (r != temp)
         {
             postorder(r.left);             
             postorder(r.right);
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
         }
     }     
 }
