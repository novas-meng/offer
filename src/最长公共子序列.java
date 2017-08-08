import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/31.
 * 我们有两个字符串m和n，如果它们的子串a和b内容相同，则称a和b是m和n的公共子序列。
 * 子串中的字符不一定在原字符串中连续。
 例如字符串“abcfbc”和“abfcab”，其中“abc”同时出现在两个字符串中，因此“abc”是它们的公共子序列。
 此外，“ab”、“af”等都是它们的字串。
 现在给你两个任意字符串（不包含空格），请帮忙计算它们的最长公共子序列的长度。
 输入描述:
 输入包含多组数据。

 每组数据包含两个字符串m和n，它们仅包含字母，并且长度不超过1024。
 输出描述:
 对应每组输入，输出最长公共子序列的长度。
 示例1
 输入

 abcfbc abfcab
 programming contest
 abcd mnp
 输出

 4
 2
 0
 */
public class 最长公共子序列 {
    public static int getLongestSeries(char[] A,char[] B)
    {
        int[][] array=new int[A.length][B.length];
        for (int i=0;i<A.length;i++)
        {
            if(A[i]==B[0])
            {
                array[i][0]=1;
            }
            else if(i>=1)
            {
                array[i][0]=array[i-1][0];
            }
        }
        for (int i=0;i<B.length;i++)
        {
            if(A[0]==B[i])
            {
                array[0][i]=1;
            }
            else if(i>=1)
            {
                array[0][i]=array[0][i-1];
            }
        }

        for (int i=1;i<A.length;i++)
        {
            for (int j=1;j<B.length;j++)
            {
                if(A[i]==B[j])
                {
                    array[i][j]=array[i-1][j-1]+1;
                }
                else
                {
                    array[i][j]=Math.max(array[i-1][j],array[i][j-1]);
                }
            }
        }
        return array[A.length-1][B.length-1];
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            String line=scanner.nextLine();
            String[] var=line.split(" ");
            System.out.println(getLongestSeries(var[0].toCharArray(),var[1].toCharArray()));
        }
    }
}
