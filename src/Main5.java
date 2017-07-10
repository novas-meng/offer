import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/20.
 */
public class Main5 {
    public static void getCount(int[] array)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<array.length;i++)
        {
            if(map.containsKey(array[i]))
            {
                map.put(array[i],map.get(array[i])+1);
            }
            else
            {
                map.put(array[i],1);
            }
        }
        int all=(array.length*(array.length-1))/2;
        int temp=all;
        for (Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()>=2)
            {
                int l=(entry.getValue()*(entry.getValue()-1))/2;
                all=all-l;
            }
        }
        if(temp==all)
        {
            all=all-1;
        }
        System.out.println(all+1);
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
        getCount(array);
    }
}
