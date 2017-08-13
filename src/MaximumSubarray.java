/**
 * Created by mengfanshan on 2017/8/13.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int[] sum=new int[nums.length];
        sum[0]=nums[0];
        int max=nums[0];
        for (int i=1;i<nums.length;i++)
        {
            sum[i]=Math.max(sum[i-1]+nums[i],nums[i]);
            if(sum[i]>max)
            {
                max=sum[i];
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        int[] array={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));
    }
}
