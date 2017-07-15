import java.util.ArrayList;

/**
 * Created by mengfanshan on 2017/7/11.
 */
public class maxInWindows {
    public static void main(String[] args)
    {
        int[] nums={2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(nums,3));
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list=new ArrayList<>();
        if(size==0)
        {
            return list;
        }
        for (int i=0;i+size-1<num.length;i++)
        {
            int max=Integer.MIN_VALUE;
            for (int j=i;j<i+size;j++)
            {
                if(num[j]>max)
                {
                    max=num[j];
                }
            }
            list.add(max);
        }
        return list;
    }
}
