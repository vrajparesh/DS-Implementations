package CompareSort;
import java.util.*;
public class Generate
{ 
    public static void generate(int[] r)
    {
        int[] a=new int[1002];
        a=r.clone();
        Arrays.sort(a);
        Integer[] d = new Integer[r.length];
		for (int i = 0; i < r.length; i++) {
			d[i] = Integer.valueOf(r[i]);
		}
        Arrays.sort(d,Collections.reverseOrder());
    }
}