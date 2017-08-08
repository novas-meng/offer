import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by mengfanshan on 2017/7/20.
 * NowCoder今年买了一辆新车，他决定自己开车回家过年。回家过程中要经过n个大小收费站，每个收费站的费用不同，你能帮他计算一下最少需要给多少过路费吗？
 输入描述:
 输入包含多组数据，每组数据第一行包含两个正整数m（1≤m≤500）和n（1≤n≤30），其中n表示有n个收费站，编号依次为1、2、…、n。出发地的编号为0，终点的编号为n，即需要从0到n。

 紧接着m行，每行包含三个整数f、t、c，（0≤f, t≤n; 1≤c≤10），分别表示从编号为f的地方开到t，需要交c元的过路费。
 输出描述:
 对应每组数据，请输出至少需要交多少过路费。
 示例1
 输入

 8 4
 0 1 10
 0 2 5
 1 2 2
 1 3 1
 2 1 3
 2 3 9
 2 4 2
 3 4 4
 输出

 7
 */
public class 过年回家 {
    static int maxvalue=100000000;
    public static int getGraphMin(int[][] array)
    {
        int begin=0;
        int[] distince=new int[array.length];
        for (int i=0;i<distince.length;i++)
        {
            distince[i]=array[begin][i];
        }
        Set<Integer> S=new HashSet<>();
        Set<Integer> U=new HashSet<>();
        for (int i=0;i<distince.length;i++)
        {
            if(i!=begin)
            {
                U.add(i);
            }
        }
        while (U.size()>0)
        {
            int minindex=-1;
            int min=Integer.MAX_VALUE;
            for (int i=0;i<distince.length;i++)
            {
                if(U.contains(i)&&distince[i]<min)
                {
                    min=distince[i];
                    minindex=i;
                }
            }
            //更新distince数组
            for (int i=0;i<distince.length;i++)
            {
                if(distince[i]>distince[minindex]+array[minindex][i])
                {
                    distince[i]=distince[minindex]+array[minindex][i];
                }
            }
            U.remove(minindex);
        }
        return distince[array.length-1];
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int m=scanner.nextInt();
            int n=scanner.nextInt();
            int[][] array=new int[n+1][n+1];
            for (int i=0;i<m;i++)
            {
                array[scanner.nextInt()][scanner.nextInt()]=scanner.nextInt();
            }
            for (int i=0;i<array.length;i++)
            {
                for (int j=0;j<array.length;j++)
                {
                    if(array[i][j]==0)
                    {
                        array[i][j]=maxvalue;
                    }
                }
            }
           System.out.println( getGraphMin(array));
        }
    }

}
