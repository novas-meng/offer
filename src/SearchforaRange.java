/**
 * Created by mengfanshan on 2017/8/11.
 * Given an array of integers sorted in ascending order,
 * find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class SearchforaRange {
    public static void main(String[] args)
    {
        int[] array={5,7,7,8,8,10};
        System.out.println(getbegin(array,8));
        System.out.println(getend(array,8));


    }

    public static int getbegin(int[] nums,int target)
    {
        int begin=0;
        int end=nums.length-1;
        while (begin<=end)
        {
            int mid=end-(end-begin)/2;
            System.out.println(begin+","+end+","+mid);
            if(nums[mid]>target)
            {
                end=mid-1;
            }
            else if(nums[mid]<target)
            {
                begin=mid+1;
            }
            else
            {
                if(begin==end-1||begin==end)
                {
                    if(nums[begin]==target)
                    {
                        return begin;
                    }
                    else if(nums[end]==target)
                    {
                        return end;
                    }
                    else
                    {
                        return -1;
                    }
                }
                end=mid;
            }
        }
        return -1;
    }

    public static int getend(int[] nums,int target)
    {
        int begin=0;
        int end=nums.length-1;
        while (begin<=end)
        {
            //System.out.println("begin="+begin+",end="+end);
            int mid=end-(end-begin)/2;
            if(nums[mid]>target)
            {
                end=mid-1;
            }
            else if(nums[mid]<target)
            {
                begin=mid+1;
            }
            else
            {
                if(begin==mid||end==mid)
                {
                    return mid;
                }
                begin=mid;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int begin=getbegin(nums,target);
        int end=getend(nums,target);
        int[] array=new int[2];
        array[0]=begin;
        array[1]=end;
        return array;
    }

}
