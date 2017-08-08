import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/23.
 *  7
 3 8
 8 1 0
 2 7 4 4
 4 5 2 6 5
 如上图所示，从一个数字三角形的顶部走到底部有很多条不同的路径，
 规则是只能从当前节点走到下一层相邻的节点，即下一层的左边或右边。
 例如第三行第二个数字“1”只能走到第四行的第二个数字“7”与第三个数字“4”。
 请寻找最佳一条路径，使得这条路径上节点的数字总和最大。
 输入描述:
 输入包含多组。每组数据的第一行包含一个正整数n（1≤n≤100），代表三角形的层数。

 紧接着有n行数字，第i（1≤i≤n）行包含i个自然数。
 输出描述:
 对应每组数据，输出最大的和。
 示例1
 输入

 5
 7
 3 8
 8 1 0
 2 7 4 4
 4 5 2 6 5
 输出

 30
 */
public class 数字三角形 {
    public static int getLongestPath(int[][] array)
    {
        int[] temp=new int[array.length];
        int max=0;
        for (int i=0;i<array.length;i++)
        {
            int pre=0;
            for (int j=0;j<temp.length;j++)
            {
                int current=temp[j];
                temp[j]=Math.max(pre+array[i][j],temp[j]+array[i][j]);
                if(temp[j]>max)
                {
                    max=temp[j];
                }
                pre=current;
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int linecount=scanner.nextInt();
            int[][] array=new int[linecount][linecount];
            for (int i=0;i<array.length;i++)
            {
                for (int j=0;j<i+1;j++)
                {
                    array[i][j]=scanner.nextInt();
                }
            }
            for (int i=0;i<array.length;i++)
            {
                for(int j=0;j<array.length;j++)
                {
                   // System.out.print(array[i][j]+" ");
                }
               // System.out.println();
            }
            System.out.println(getLongestPath(array));
        }
    }
}
