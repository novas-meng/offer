import java.util.ArrayList;

/**
 * Created by mengfanshan on 2017/7/16.
 * ����һ���������飬����ͨ�����ö��ֲ��ҵķ�ʽ����λĳһԪ�أ����д���ֲ��ҵ��㷨���������в���ָ��Ԫ�ء�
 ����һ����������A�����Ĵ�Сn��ͬʱ����Ҫ���ҵ�Ԫ��val���뷵�����������е�λ��(��0��ʼ)���������ڸ�Ԫ�أ�����-1������Ԫ�س��ֶ�Σ��뷵�ص�һ�γ��ֵ�λ�á�
 ����������
 [1,3,5,7,9],5,3
 ���أ�1
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
