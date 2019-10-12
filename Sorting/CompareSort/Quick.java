package CompareSort;
public class Quick
{   static int partition(int a[],int low,int high)
    {
        int pivot=a[high];
        int i=low-1;
        for(int j=low;j<high;j++)
        {
            if(a[j]<=pivot)
            {
                i++;
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp=a[i+1];
        a[i+1]=a[high];
        a[high]=temp;
        return i+1;
    }
    static void QuickSort(int a[],int low,int high)
    {
        if(low<high)
        {
            int pi=partition(a,low,high);
            QuickSort(a,low,pi-1);
            QuickSort(a,pi+1,high);
        }
    }
    
    static long sort(int arr[])
    {   int high=arr.length;
        int low=0;
        long start=Timer.start();
        QuickSort(arr, low, high);
        long end=Timer.end();
        return (end-start);
    }
}