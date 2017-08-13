import java.util.*;

/**
 * Created by mengfanshan on 2017/8/13.
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class PermutationsII {
    public static void main(String[] args)
    {
        int[] array={1,1,2};
        System.out.println(permuteUnique(array));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
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
                //index=index*i;
                //System.out.println("index="+index);
                Set<List<Integer>> set=new HashSet<>();
                while (!queue.isEmpty())
                {
                    List<Integer> list=queue.poll();
                    if(list.size()!=i)
                    {
                        break;
                    }
                    //System.out.println("list="+list);
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
                        set.add(newList);
                    }
                }
               // System.out.println(set.size());
                queue.addAll(set);
            }
        }
        //System.out.println(queue.size());
        List<List<Integer>> reslist=new ArrayList<>();
        reslist.addAll(queue);
        return reslist;
    }
}
