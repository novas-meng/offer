import java.util.ArrayList;

/**
 * Created by mengfanshan on 2017/7/16.
 * 对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，在数组中查找指定元素。
 给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。若该元素出现多次，请返回第一次出现的位置。
 测试样例：
 [1,3,5,7,9],5,3
 返回：1
 */
public class getPos {
    public static void main(String[] args)
    {
        int[] array={4,4,10,21};
        System.out.println(getPos(array,args.length,4));
    }
    public static int getPos(int[] A, int n, int val) {
        ArrayList<Integer> B=new ArrayList<>();
        ArrayList<Integer> C=new ArrayList<>();
        for (int i=0;i<A.length;i++)
        {
            if(!B.contains(A[i]))
            {
                B.add(A[i]);
                C.add(i);
            }
        }
        int[] B_array=new int[B.size()];
        for(int i=0;i<B_array.length;i++)
        {
            B_array[i]=B.get(i);
        }
        // write code here
        int begin=0;
        int end=B_array.length-1;
        int middle=-1;
        while (begin<=end)
        {
             middle=end-(end-begin)/2;
            if(B_array[middle]==val)
            {
                return C.get(middle);
            }
            else if(B_array[middle]>val)
            {
                end=middle-1;
            }
            else
            {
                begin=middle+1;
            }
        }
        return -1;
    }

}
