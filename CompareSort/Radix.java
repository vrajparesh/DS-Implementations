package CompareSort;
public class Radix
{   int getMax(int a[],int n)
    {
        int max=a[0];
        for(int i=1;i<n;i++)
        {
            if(a[i]>max)
                max=a[i];
        }
        return max;
    }
    static void countSort(int arr[],int n, int exp)
    {
        int output[]=new int[n];
        int i;
        int count[]=new int[10];
        Arrays.fill(count,0);
        for(i=0;i<n;i++)
            count[(a[i]/exp)%10]++;
        for(i=1;i<10;i++)
            count[i]+=count[i-1];
        for(i=n-1;i>=0;i--)
        {
            output[count[(a[i]/exp)%10]-1]=arr[i];
            count[(a[i]/exp)%10]--;
        }    
        for(i=0;i<n;i++)
        a[i]=output[i];
    }
    static long sort(int arr[])
    {  
        long start=Timer.start();
        int m=getMax(arr, n);
        for(int exp=1;m/exp>0;exp*=10)    
            countSort(arr, n, exp);
        
        long end= Timer.end();
        return (end-start);
    }
}
