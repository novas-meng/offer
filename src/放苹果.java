import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/23.
 * 把 M 个同样的苹果放在 N 个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 注意：5、1、1 和 1、5、1 是同一种分法，即顺序无关。
 输入描述:
 输入包含多组数据。

 每组数据包含两个正整数 m和n（1≤m, n≤20）。
 输出描述:
 对应每组数据，输出一个整数k，表示有k种不同的分法。
 示例1
 输入

 7 3
 输出

 8
 */
/*

思路
首先设二维数组int[][] array
array[n][m] 表示m个苹果放入n个篮子中，所有情况的个数
分为两种情况，
第一种情况是 存在空篮子的情况，那么将这个篮子拿走不影响可能结果,array[n-1][m]
第二种情况是，当苹果数大于篮子数时，每个篮子都不为空的情况，这个时候，每个篮子减少一个1个苹果，那么不影响结果array[n][m-n]
所以array[n][m]=array[n-1][m]+array[n][m-n]
当篮子数大于苹果数时，array[n][m]=array[m][m]


 */
public class 放苹果 {
    //m表示苹果数 n表示篮子数
    public static int getCount(int m,int n)
    {
        int[][] array=new int[n+1][m+1];
        for (int i=0;i<array.length;i++)
        {
            array[i][0]=1;
        }
        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=m;j++)
            {
                if(j>=i)
                {
                    array[i][j]=array[i-1][j]+array[i][j-i];
                }
                else
                {
                    array[i][j]=array[i-1][j];
                }
            }
        }
        return array[n][m];
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int m=scanner.nextInt();
            int n=scanner.nextInt();
            System.out.println(getCount(m,n));
        }
    }
}
