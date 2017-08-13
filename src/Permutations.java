import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mengfanshan on 2017/8/13.
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
/*
全排列算法
以1 2 3 4 为例
首先使用队列进行保存
将1 进入队列

当进行当i 的时候，队列里面存储的是 i-1的全排列

比如 进行到3时，队列里面存储着 2的全排列，具体为 （1，2）和（2，1）
然后对于每一个排列，比如（1，2）那么 3 有三个位置可以选择，(3,1,2) (1,3,2) (1,2,3)
然后根据这个思想就可以正确求解


 */
public class Permutations {
    public static void main(String[] args)
    {
        int[] array={1,2,3,4};
        System.out.println(permute(array));
    }
    public static List<List<Integer>> permute(int[] nums) {
        int index=1;
        Queue<List<Integer>> queue=new LinkedList<>();
        for (int i=0;i<nums.length;i++)
        {
            if(queue.isEmpty())
            {
                List<Integer> list=new ArrayList<>();
                list.add(nums[i]);
                queue.add(list);
            }
            else
            {
                index=index*i;
               // System.out.println("index="+index);
                for (int j=0;j<index;j++)
                {
                    List<Integer> list=queue.poll();
                   // System.out.println("list="+list);
                    for (int k=0;k<list.size()+1;k++)
                    {
                        List<Integer> newList=new ArrayList<>();
                        int count=0;
                        for (int p=0;p<list.size()+1;p++)
                        {
                            if(p==k)
                            {
                                newList.add(nums[i]);
                            }
                            else
                            {
                                newList.add(list.get(count));
                                count++;
                            }
                        }
                        queue.add(newList);
                    }
                }
            }
        }
        //System.out.println(queue.size());
        List<List<Integer>> reslist=new ArrayList<>();
        reslist.addAll(queue);
        return reslist;
    }
}
