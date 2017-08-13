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
ȫ�����㷨
��1 2 3 4 Ϊ��
����ʹ�ö��н��б���
��1 �������

�����е�i ��ʱ�򣬶�������洢���� i-1��ȫ����

���� ���е�3ʱ����������洢�� 2��ȫ���У�����Ϊ ��1��2���ͣ�2��1��
Ȼ�����ÿһ�����У����磨1��2����ô 3 ������λ�ÿ���ѡ��(3,1,2) (1,3,2) (1,2,3)
Ȼ��������˼��Ϳ�����ȷ���


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
