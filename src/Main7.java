import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/23.
 */
public class Main7 {
    public static int partition(int[] array,int p,int q)
    {
        int index=p-1;
        int key=array[q];
        int temp;
        for(int i=p;i<q;i++)
        {
            if(array[i]<key)
            {
                index++;
                temp=array[i];
                array[i]=array[index];
                array[index]=temp;
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
    public static int getmaxmin(int[] array)
    {
        int max=0;
        for (int i=2;i<array.length;i++)
        {
            int d=array[i]-array[i-2];
            if(d>max)
            {
                max=d;
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int length=scanner.nextInt();
        int[] array=new int[length];
        for (int i=0;i<array.length;i++)
        {
            array[i]=scanner.nextInt();
        }
        quicksort(array,0,array.length-1);
        System.out.println(getmaxmin(array));
    }
}
