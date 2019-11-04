import java.util.Scanner;
import java.io.IOException;

class Activity
{   
    int start
    int finish;
    Activity()
    {
        this.start=0;
        this.finish=0;
    }

    public static void sortarray(Activity arr[])
    { 
        Activity temp;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i].finish>arr[i+1].finish)
            {
                temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }

        }
    }

    public static void printmaxacts(Activity arr[])
    {   int i=0;
        System.out.println("The following are the activities to be performed\n"+(i)+") ("+arr[i].start+","+arr[i].finish+")");
        for (int j = 1; j < arr.length; j++) 
        { 
      	    if (arr[j].start>= arr[i].finish) 
      	    {	 
		System.out.println((j)+") ("+arr[j].start+","+arr[j].finish+")"); 
		i = j; 
      	    } 
        } 
    }

    public static void main(String[] args)throws IOException
    {  
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of activities possible");
        int n=sc.nextInt();
        Activity arr[]=new Activity[n];
        for(int i = 0; i<arr.length;i++)
            arr[i] = new Activity();
        for(int i=0; i<=n-1; i++)
	    {
            System.out.println("Enter the start and end time of activity no. "+(i+1));
            arr[i].start=sc.nextInt();
            arr[i].finish=sc.nextInt();
        }
        sortarray(arr);
        printmaxacts(arr);
        sc.close();
    }
}
