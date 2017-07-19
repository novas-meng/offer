import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/18.
 * 英语中，有些单词可以出现在其他单词后面。例如“Love”可以出现在“I”之后，“You”可以出现在“Love”之后，因此它们能构成“I Love You”这句话。
 现在给你一些单词间的关系，你能计算出最多能有几个单词组合在一起构成一句话吗？
 输入描述:
 输入包含多组数据。

 每组数据的第一行包含一个正整数n (1≤n≤10000)。

 紧接着n行单词关系，每行包含两个单词A和B，表示单词B能出现在A后面。单词长度不超过32个字符，并且只有字母组成。

 不存在循环的依赖关系。
 输出描述:
 对应每组数据，输出最多有几个单词能构成一个句子。
 示例1
 输入

 1
 hello world
 3
 I love
 love you
 love me
 输出

 2
 3

 思路：使用图的最短路径算法，找到距离最长的两个点（不包含两个点之间不连通的情况）
 */
public class zuichangjuzi {
    public static int getLongestPath(int[][] array)
    {
        int[] distince=new int[array.length];
        for (int i=0;i<array.length;i++)
        {
            int rudu=0;
            for (int j=0;j<array.length;j++)
            {
                if(array[j][i]==1)
                {
                    rudu=rudu+array[j][i];
                }
            }
            distince[i]=rudu;
        }
        Queue<Integer> _zeroQueue=new LinkedList<>();
        for (int i=0;i<distince.length;i++)
        {
            if(distince[i]==0)
            {
                _zeroQueue.add(i);
                distince[i]=-1;
            }
        }
        //存储末尾节点为i的最长路径的长度
        int[] maxpath=new int[array.length];
        while (!_zeroQueue.isEmpty())
        {
            int node = _zeroQueue.poll();

            //System.out.println("node="+node);
            //减少这个点连接的点的入度
            for (int i=0;i<distince.length;i++)
            {
                if(array[node][i]>0)
                {
                    distince[i]=distince[i]-1;
                }
                //System.out.println("distince="+distince[i]);
                if(distince[i]==0)
                {
                    _zeroQueue.add(i);
                    distince[i]=-1;
                }
            }
            int max=0;
            for (int j = 0; j < array.length; j++) {
                if (array[j][node] == 1) {
                    if(maxpath[j]+1>max)
                    {
                        max=maxpath[j]+1;
                    }
                }
            }
            maxpath[node]=max;

        }
        int max=0;
        for (int i=0;i<maxpath.length;i++)
        {
            if(maxpath[i]>max)
            {
                max=maxpath[i];
            }
            //System.out.println(maxpath[i]);
        }
        return max;
    }
    static int maxvalue=100000;
    public static void main(String[] args)throws IOException
    {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String l=bufferedReader.readLine();
        while (l!=null)
        {
            int sentencecount=Integer.valueOf(l);
            ArrayList<String> sentencelist=new ArrayList<>();
            ArrayList<String> wordlist=new ArrayList<>();
            for (int i=0;i<sentencecount;i++)
            {
                String s=bufferedReader.readLine();
                sentencelist.add(s);
                String[] var=s.split(" ");
                for (int j=0;j<var.length;j++)
                {
                    if(!wordlist.contains(var[j]))
                    {
                        wordlist.add(var[j]);
                    }
                }
            }
            int[][] array=new int[wordlist.size()][wordlist.size()];
            for (int i=0;i<sentencecount;i++)
            {
                String line=sentencelist.get(i);
                String[] var=line.split(" ");
                int index1=wordlist.indexOf(var[0]);
                int index2=wordlist.indexOf(var[1]);
             //   System.out.println("index1="+index1+","+index2+","+line+","+var[0]+","+var[1]);
                array[index1][index2]=1;
            }
            System.out.println("wordlist="+wordlist);
            for (int i=0;i<array.length;i++)
            {
                for (int j=0;j<array.length;j++)
                {
                    System.out.print(array[i][j]+" ");
                }
                System.out.println();
            }
            int max =getLongestPath(array);

            System.out.println(max+1);
            l=bufferedReader.readLine();
        }
    }
}
