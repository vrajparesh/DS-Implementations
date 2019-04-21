//BubbleSort
package CompareSort;
public class Bubble
{
    static long sort(int arr[])
    {  
        long start=Timer.start();//Time measure at the start of method
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {   for (int j = 0; j < n-i-1; j++)
            {    if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        long end= Timer.end();//Time measure at the end of method
        return (end-start);
    }
}
