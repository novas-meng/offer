import java.util.ArrayList;

/**
 * Created by mengfanshan on 2017/7/17.
 * 1.输入是一个只含有 0 和 1 的二维矩阵，每一行都是排过序的，
 * 也就是说每一行前一部分都 是 0,剩下的全都是 1。请找哪些行包含的 1 最多。要求对于 MxN 的矩阵，时间复杂度是 O(M+N)，空间复杂度是 O(1)
 *
 */
public class SUNONE {
    public static void main(String[] args)
    {
        int[] array1={0,0,0,0,0,0,0,1,1,1,1,1};
        int[] array2={0,0,1,1,1,1,1,1,1,1,1,1};
        int[] array3={0,0,0,0,0,0,1,1,1,1,1,1};
        int[] array4={0,0,0,0,0,0,0,0,0,1,1,1};
        int[] array5={0,0,0,0,0,0,0,1,1,1,1,1};
        int[] array6={0,0,0,1,1,1,1,1,1,1,1,1};
        int[][] array=new int[6][];
        array[0]=array1;
        array[1]=array2;
        array[2]=array3;
        array[3]=array4;
        array[4]=array5;
        array[5]=array6;
        getMax(array);

    }
    public static void  getMax(int[][] martix)
    {
        int hang=0;
        int lie=martix[0].length-1;
        int max=0;
        while (lie>=0&&martix[hang][lie]==1)
        {
            lie--;
            max++;
        }
        ArrayList<Integer> list=new ArrayList<>();
        list.add(hang);
        int newlie=0;

        while (hang<martix.length-1)
        {
            hang=hang+1;
             newlie=lie;
            while (newlie>=0&&martix[hang][newlie]==1)
            {
                newlie=newlie-1;
            }
            newlie=newlie+1;
            //System.out.println("newlie="+newlie+"  lie="+lie);
            if(newlie==lie)
            {
                list.add(hang);
            }
            else if(newlie<lie)
            {
                max=martix[0].length-newlie;
                list.clear();
                list.add(hang);
                lie=newlie;
            }
        }
        for (int i=0;i<list.size();i++)
        {
            System.out.println("["+list.get(i)+","+max+"]");
        }
       // System.out.println(max);
       // System.out.println(list);
    }
}
