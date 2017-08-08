/**
 * Created by mengfanshan on 2017/8/8.
 */
public class ContainerWithMostWater {

    public static void main(String[] args)
    {
        int[] array={2,1};
        System.out.println(maxArea(array));
    }
    public static int maxArea(int[] height) {

        /*
          暴力解法，超时
        int max=0;
        for (int i=0;i<height.length;i++)
        {
            for (int j=i+1;j<height.length;j++)
            {
                int now=Math.min(height[j],height[i])*(j-i);
                if(now>max)
                {
                    max=now;
                }
            }
        }
        return max;
         */
        /*
         使用收尾指针来做，当头指针大于结尾指针时，移动结尾指针

         为什么这么做，当我们移动指针的时候，需要防止一种情况，比如我们把头指针从i移动到i+1
         尾指针在j，这个时候，我们的区间为i+1,j 但是如果i i+1这个区间是最优解，那么结果就错了
         所以当头指针大于尾指针的时候，如果移动头指针，那么就可能出现 i i+1 区间为最优解，
         比如 i=1 i+1=2 array[i]=100 array[i+1]=100  j=10 array[j]=1
         那么i i+1 区间的最大值为100 ，远大于 当前最大值(10-1)*1=9,但是如果移动头指针，这种情况就会被漏掉
         但是如果移动尾指针，把j 移动到j-1 位置，j-1 j 最值的最大值为 min(array[j],array[j-1])
         小于当前的最小值的，因为array[i]> array[j] 所以移动尾指针不影响

         */
        int begin=0;
        int end=height.length-1;
        int max=0;
        while (begin<end)
        {
            max=Math.max(max,Math.min(height[begin],height[end])*(end-begin));
            if(height[begin]>height[end])
            {
                end--;
            }
            else
            {
                begin++;
            }
        }
        return max;
    }
}
