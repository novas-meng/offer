/**
 * Created by mengfanshan on 2017/8/13.
 * Given a sorted array and a target value,
 * return the index if the target is found.
 * If not, return the index where
 * it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 ¡ú 2
 [1,3,5,6], 2 ¡ú 1
 [1,3,5,6], 7 ¡ú 4
 [1,3,5,6], 0 ¡ú 0
 */
public class SearchInsertPosition {
    public static void main(String[] args)
    {

    }
    public int searchInsert(int[] nums, int target) {
        for (int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                return i;
            }
            else if(nums[i]>target)
            {
                if(i==0)
                {
                    return 0;
                }
                else
                {
                    return i;
                }
            }
        }
        return nums.length;
    }

}
