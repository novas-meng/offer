/**
 * Created by mengfanshan on 2017/8/9.
 * Given an array S of n integers,
 * find three integers in S such that the sum is closest to a given number,
 * target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class _3SumClosest {
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
    public static int threeSumClosest(int[] nums, int target) {
        quicksort(nums,0,nums.length-1);
        int min=Integer.MAX_VALUE;
        int res=0;
        for (int i=0;i<nums.length;i++)
        {
            int sum=target-nums[i];
            int begin=i+1;
            int end=nums.length-1;
            while (begin<end)
            {
                int s=nums[begin]+nums[end];
                if(Math.abs(sum-s)<min)
                {
                    min=Math.abs(sum-s);
                    res=nums[i]+s;
                }
                if(s==sum)
                {
                    return target;
                }
                else if(s>sum)
                {
                    end--;
                }
                else
                {
                    begin++;
                }

            }
        }
        return res;
    }
    public static void main(String[] args)
    {
        int[] array={0,1,2};
        System.out.println(threeSumClosest(array,3));

    }
}
