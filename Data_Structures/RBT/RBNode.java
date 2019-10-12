package RBT;

 class RBNode 
 {    
     RBNode left, right;
     int element;
     int color;

     public RBNode(int data)
     {
         this( data, null, null );
     } 
     public RBNode(int data, RBNode lt, RBNode rt)
     {
         left = lt;
         right = rt;
         element = data;
         color = 1;
     }    
 }