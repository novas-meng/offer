import java.io.BufferedReader;
import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/8/1.
 */
public class sunthree {
    public static int partition(int[] array,int p,int q)
    {
        int key=array[q];
        int index=p-1;
        int temp;
        for (int i=p;i<q;i++)
        {
            if(array[i]<key)
            {
                index++;
                temp=array[index];
                array[index]=array[i];
                array[i]=temp;
            }
        }
        index++;
        temp=array[q];
        array[q]=array[index];
        array[index]=temp;
        return index;
    }
    public static void quicksort(int[] array,int p,int q)
    {
        if(p<q)
        {
            int partition=partition(array,p,q);
            quicksort(array,p,partition-1);
            quicksort(array,partition+1,q);
        }
    }
    public static int getCount(int[] h,int[] w)
    {
        int windex=0;
        int i=0;
        while (i<h.length)
        {
            int flag=0;
            for (int j=windex;j<w.length;j++)
            {
                if(w[j]>=h[i])
                {
                    flag=1;
                    windex=j+1;
                    break;
                }
            }
            if(flag==0)
            {
                return i;
            }
            i++;
        }
        return h.length;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int n=scanner.nextInt();
            int[] h=new int[n];
            for (int i=0;i<h.length;i++)
            {
                h[i]=scanner.nextInt();
            }
            int m=scanner.nextInt();
            int[] w=new int[m];
            for (int i=0;i<m;i++)
            {
                w[i]=scanner.nextInt();
            }
            quicksort(h,0,h.length-1);
            quicksort(w,0,w.length-1);
            System.out.println(getCount(h,w));
        }
    }
}
