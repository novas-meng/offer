import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/19.
 */
public class Main1 {
    public static int partition(int p,int q,int[] array)
    {
        int index=p-1;
        int temp;
        int key=array[q];
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
        temp=array[index];
        array[index]=key;
        array[q]=temp;
        return index;

    }
    public static void quicksort(int array[],int p,int q)
    {
        if(p<q)
        {
            int partition=partition(p,q,array);
           // System.out.println(partition);
            quicksort(array,p,partition-1);
            quicksort(array,partition+1,q);
        }
    }
    public static int getFirstSame(int[] sort,int[] source)
    {
        int index=-1;
        int count=0;
        for (int i=0;i<sort.length;i++)
        {
            int temp=index;
            for (int j=0;j<source.length;j++)
            {
                if(source[j]==sort[i])
                {
                    if(j>index)
                    {
                        index=j;
                        count++;
                        break;
                    }
                }
            }
            if(index==temp)
            {
                break;
            }

        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int length=scanner.nextInt();
        int[] array=new int[length];
        for(int i=0;i<array.length;i++)
        {
            array[i]=scanner.nextInt();
        }
        int[] source=new int[array.length];
        System.arraycopy(array,0,source,0,array.length);
        quicksort(source,0,array.length-1);
        System.out.println(array.length-getFirstSame(source,array));
    }
}
