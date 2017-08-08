import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by mengfanshan on 2017/7/20.
 * NowCoder��������һ���³����������Լ������ؼҹ��ꡣ�ؼҹ�����Ҫ����n����С�շ�վ��ÿ���շ�վ�ķ��ò�ͬ�����ܰ�������һ��������Ҫ�����ٹ�·����
 ��������:
 ��������������ݣ�ÿ�����ݵ�һ�а�������������m��1��m��500����n��1��n��30��������n��ʾ��n���շ�վ���������Ϊ1��2������n�������صı��Ϊ0���յ�ı��Ϊn������Ҫ��0��n��

 ������m�У�ÿ�а�����������f��t��c����0��f, t��n; 1��c��10�����ֱ��ʾ�ӱ��Ϊf�ĵط�����t����Ҫ��cԪ�Ĺ�·�ѡ�
 �������:
 ��Ӧÿ�����ݣ������������Ҫ�����ٹ�·�ѡ�
 ʾ��1
 ����

 8 4
 0 1 10
 0 2 5
 1 2 2
 1 3 1
 2 1 3
 2 3 9
 2 4 2
 3 4 4
 ���

 7
 */
public class ����ؼ� {
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
            //����distince����
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
