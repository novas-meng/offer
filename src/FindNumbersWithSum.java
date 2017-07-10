import java.util.ArrayList;

/**
 * Created by mengfanshan on 2017/7/6.
 */
public class FindNumbersWithSum {
    public static void main(String[] args)
    {
        int[] array={1,2,3,4,5,6,7};
        FindNumbersWithSum(array,10);
    }
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int i=0;
        int j=array.length-1;
        int begin=0;
        int end=0;
        int mul=Integer.MAX_VALUE;
        ArrayList<Integer> list=new ArrayList<>();
        while (i<j)
        {
            if(array[i]+array[j]==sum)
            {
                if(array[i]*array[j]<mul)
                {
                    mul=array[i]*array[j];
                    begin=Math.min(array[i],array[j]);
                    end=Math.max(array[i],array[j]);
                    list.add(begin);
                    list.add(end);
                }
                i++;
            }
            else if(array[i]+array[j]<sum)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        System.out.println(begin+","+end);
        return list;
    }
}
