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
 * Ӣ���У���Щ���ʿ��Գ������������ʺ��档���硰Love�����Գ����ڡ�I��֮�󣬡�You�����Գ����ڡ�Love��֮����������ܹ��ɡ�I Love You����仰��
 ���ڸ���һЩ���ʼ�Ĺ�ϵ�����ܼ����������м������������һ�𹹳�һ�仰��
 ��������:
 ��������������ݡ�

 ÿ�����ݵĵ�һ�а���һ��������n (1��n��10000)��

 ������n�е��ʹ�ϵ��ÿ�а�����������A��B����ʾ����B�ܳ�����A���档���ʳ��Ȳ�����32���ַ�������ֻ����ĸ��ɡ�

 ������ѭ����������ϵ��
 �������:
 ��Ӧÿ�����ݣ��������м��������ܹ���һ�����ӡ�
 ʾ��1
 ����

 1
 hello world
 3
 I love
 love you
 love me
 ���

 2
 3

 ˼·��ʹ��ͼ�����·���㷨���ҵ�������������㣨������������֮�䲻��ͨ�������
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
        //�洢ĩβ�ڵ�Ϊi���·���ĳ���
        int[] maxpath=new int[array.length];
        while (!_zeroQueue.isEmpty())
        {
            int node = _zeroQueue.poll();

            //System.out.println("node="+node);
            //������������ӵĵ�����
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
