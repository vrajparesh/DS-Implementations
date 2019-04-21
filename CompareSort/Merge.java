package CompareSort;
public class Merge
{   
    static void merge(int[] arr, int l, int m, int h)
    {
        int i=l,j=m+1;k=0;
        int[] c=new int[h-l+1];
        while(i<=m&&j<=h)
        {
            if(arr[i]<=arr[j])
                c[k++]=arr[i++];
            else c[k++]=arr[j++];    
        }
        while(i<=m)
            c[k++]=arr[i++];
        while(j<=h)
            c[k++]=arr[j++];
        k=0;
        for(i=l;i<=h;i++)
            arr[i]=c[k++];        

    }
    static void MergeSort(int[] arr, int l, int h)
    {
        if(h-l+1>1)
        {
            int m= (h-l)/2;
            MergeSort(arr,l,m);
            MergeSort(arr,m+1,h);
            merge(arr,l,m,h);
        }
    }
    static long sort(int arr[])
    {  int h=arr.length;
        int l=0;
        long start=Timer.start();
        MergeSort(arr,l,h);
        return (end-start);
    }
}