import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/30.
 * UNIX系统下有一个行编辑器ed，它每次只对一行文本做删除一个字符、
 * 插入一个字符或替换一个字符三种操作。例如某一行的内容是“ABC”，
 * 经过把第二个字符替换成“D”、删除第一个字符、末尾插入一个字符“B”，
 * 这三步操作后，内容就变成了“DCB”。即“ABC”变成“DCB”需要经过3步操作，
 * 我们称它们的编辑距离为3。
 现在给你两个任意字符串（不包含空格），请帮忙计算它们的最短编辑距离。
 输入描述:
 输入包含多组数据。

 每组数据包含两个字符串m和n，它们仅包含字母，并且长度不超过1024。
 输出描述:
 对应每组输入，输出最短编辑距离。
 示例1
 输入

 ABC CBCD
 ABC DCB
 输出

 2
 3
 */
public class 最短编辑距离 {
    public static int getMinEditDistance(char[] A,char[] B)
    {
        int[][] martix=new int[A.length+1][B.length+1];
        for (int i=0;i<martix.length;i++)
        {
            martix[i][0]=i;
        }
        for (int i=0;i<=B.length;i++)
        {
            martix[0][i]=i;
        }
        for (int i=1;i<martix.length;i++)
        {
            for (int j=1;j<=B.length;j++)
            {
                if(A[i-1]==B[j-1])
                {
                    martix[i][j]=martix[i-1][j-1];
                }
                else
                {
                    int insert=martix[i][j-1]+1;
                    int change=martix[i-1][j-1]+1;
                    int del=martix[i-1][j]+1;
                    int min1=Math.min(insert,change);
                    min1=Math.min(min1,del);
                    System.out.println("i="+i+"j="+j+"min1="+min1+","+insert+","+change+","+del);
                    martix[i][j]=min1;
                }
            }
        }
        return martix[A.length][B.length];
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            String line=scanner.nextLine();
            String[] var=line.split(" ");
            System.out.println(getMinEditDistance(var[0].toCharArray(),var[1].toCharArray()));
        }
    }
}
