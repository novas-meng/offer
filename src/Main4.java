import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/19.
 */
public class Main4 {
    public static int getpartition(int[] array,int p,int q)
    {
        int index=p-1;
        int key=array[q];
        int temp;
        for (int i=p;i<q;i++)
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
        temp=array[index];
        array[index]=array[q];
        array[q]=temp;
        return index;
    }
    public static void quicksort(int[] array,int p,int q)
    {
        if(p<q)
        {
            int partition=getpartition(array,p,q);
            quicksort(array,p,partition-1);
            quicksort(array,partition+1,q);
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int A=scanner.nextInt();
        int[] array=new int[n];
        for (int i=0;i<array.length;i++)
        {
            array[i]=scanner.nextInt();
        }
        quicksort(array,0,array.length-1);
        long all=A;
        for (int i=0;i<array.length;i++)
        {
            if(array[i]==all)
            {
                all=2*all;
            }
        }
        System.out.println(all);
    }
}
