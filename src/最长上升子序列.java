import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/31.
 * 广场上站着一支队伍，她们是来自全国各地的扭秧歌代表队
 * ，现在有她们的身高数据，请你帮忙找出身高依次递增的子序列。
 * 例如队伍的身高数据是（1、7、3、5、9、4、8），其中依次递增的子序列有（1、7）
 * ，（1、3、5、9），（1、3、4、8）等，其中最长的长度为4。
 输入描述:
 输入包含多组数据，每组数据第一行包含一个正整数n（1≤n≤1000）。

 紧接着第二行包含n个正整数m（1≤n≤10000），代表队伍中每位队员的身高。
 输出描述:
 对应每一组数据，输出最长递增子序列的长度。
 示例1
 输入

 7
 1 7 3 5 9 4 8
 6
 1 3 5 2 4 6
 输出

 4
 4
 */
public class 最长上升子序列 {
    public static int getMaxUpSeriesLength(int[] array)
    {
        int[] length=new int[array.length];
        for (int i=0;i<length.length;i++)
        {
            length[i]=1;
        }
        for (int i=1;i<array.length;i++)
        {
            for (int j=i-1;j>=0;j--)
            {
                if(array[i]>array[j])
                {
                    length[i]=Math.max(length[i],length[j]+1);
                }
            }
        }
        int max=0;
        for (int i=0;i<length.length;i++)
        {
          //  System.out.println(length[i]);
            if(length[i]>max)
            {
                max=length[i];
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int count=scanner.nextInt();
            int[] array=new int[count];
            for (int i=0;i<array.length;i++)
            {
                array[i]=scanner.nextInt();
            }
            int m=getMaxUpSeriesLength(array);
            System.out.println(m);
        }
    }
}
