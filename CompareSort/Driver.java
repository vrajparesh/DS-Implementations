package CompareSort;
import java.util.*;
import java.util.stream.IntStream;
public class Driver
{
    public static double average(double times[],int n)
    {   double sum=0,avg=0;
        for (int i=0;i<n;i++)
        {
            sum+=times[i];
            avg=sum/10;
        }
        return avg;
    }
    
    
    public static void main(String[] args)
    { 	
        int[] r=new int[1002];
        Random rm =new Random();
        IntStream is=rm.ints(1000,999,9999);
        r=is.toArray();
        int[] a=new int[1002];
        a=r.clone();
        Arrays.sort(a);
        Integer[] de = new Integer[r.length];
        for (int i = 0; i < r.length; i++)
        {
			de[i] = Integer.valueOf(r[i]);
		}
        Arrays.sort(de,Collections.reverseOrder());
        List<Integer> list = Arrays.asList(de);

		int[] d = list.stream()
							.mapToInt(Integer::intValue)
							.toArray();
        int[] tempr,tempa,tempd;
        double[] tsr =new double[10];
        double[] tir =new double[10];
        double[] tbr =new double[10];
        double[] tsa =new double[10];
        double[] tia =new double[10];
        double[] tba =new double[10];
        double[] tsd =new double[10];
        double[] tid =new double[10];
        double[] tbd =new double[10];
        
        for(int i=0;i<10;i++)
        {   
            tempr=r.clone();
            tempa=a.clone();
            tempd=d.clone();
            tsr[i]=Selection.sort(tempr);
            tir[i]=Insertion.sort(tempr);
            tbr[i]=Bubble.sort(tempr);
            tsa[i]=Selection.sort(tempa);
            tia[i]=Insertion.sort(tempa);
            tba[i]=Bubble.sort(tempa);
            tsd[i]=Selection.sort(tempd);
            tid[i]=Insertion.sort(tempd);
            tbd[i]=Bubble.sort(tempd);
        }
        for(int i=0;i<1000;i++)
        {
            System.out.print(r[i]+" ");
        }
        System.out.println("------------------------------------------------------------------------");
        for(int i=0;i<1000;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println("------------------------------------------------------------------------");
        for(int i=0;i<1000;i++)
        {
            System.out.print(de[i]+" ");
        }
        System.out.println("Selection Sort takes\t"+average(tsr,tsr.length)+" ns in Random Array");
        System.out.println("Insertion Sort takes\t"+average(tir,tir.length)+" ns in Random Array");
        System.out.println("Bubble Sort takes\t"+average(tbr,tbr.length)+" ns in Random Array");
        System.out.println("Selection Sort takes\t"+average(tsa,tsa.length)+" ns in Increasing Sorted Array");
        System.out.println("Insertion Sort takes\t"+average(tia,tia.length)+" ns in Increasing Sorted Array");
        System.out.println("Bubble Sort takes\t"+average(tba,tba.length)+" ns in Increasing Sorted Array");
        System.out.println("Selection Sort takes\t"+average(tsd,tsd.length)+" ns in Decreasing Sorted Array");
        System.out.println("Insertion Sort takes\t"+average(tid,tid.length)+" ns in Decreasing Sorted Array");
        System.out.println("Bubble Sort takes\t"+average(tbd,tbd.length)+" ns in Decreasing Sorted Array");
       
     
    }

}