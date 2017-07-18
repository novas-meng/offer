import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengfanshan on 2017/7/18.
 * �������ڽӾ������ʽ��������ͼ�ĵ�Դ���·���Ͷ�Դ���·��
 * �ֱ�ʹ��dijkstra�㷨��floyd�㷨
 * ����http://www.cnblogs.com/biyeymyhjob/archive/2012/07/31/2615833.html
 *
 */
public class GraphMinDistance {
    public static void main(String[] args)
    {
        int[][] array=
        {
                {0,6,3,-1,-1,-1},
                {6,0,2,5,-1,-1},
                {3,2,0,3,4,-1},
                {-1,5,3,0,2,3},
                {-1,-1,4,2,0,5},
                {-1,-1,-1,3,5,0}
        };
       // dijkstra(array);
        floyd(array);
    }
    /*
      dijkstra�㷨����0�ڵ㵽����ڵ����̾��룬���ȳ�ʼ��һ������distince����ʾ0�ڵ㵽�������нڵ�ľ���
      Ȼ���ʼ����������S��U��SΪ�Ѿ�ȷ����̾���ĵ㼯�ϣ�UΪ�������е�Ľ��
      ���ȴ�distince������ѡ��·��������С���Ǹ��ڵ�A������A��Ҫ����A�ڼ���U�У�Ȼ��A���뼯��S
      ����distince���飬������²���Ϊ
      �����¼�����ǽڵ�1����ô����ÿ���ڵ�����������1�ڵ㣬��0-1-��Ӧ�Ľڵ�ľ��� ��0-��Ӧ�ڵ�ľ��� ȡ��Сֵ���и���
      distince���飬�ظ���������

     */
//������� 0,1,2,....array.length-1
    public static void dijkstra(int[][] array)
    {

        int begin=0;
        int[] distince=new int[array.length];
        for (int i=0;i<array.length;i++)
        {
            distince[i]=array[begin][i];
        }

        Set<Integer> S=new HashSet<>();
        S.add(begin);

        Set<Integer> U=new HashSet<>();
        for (int i=0;i<array.length;i++)
        {
            if(i!=begin)
            {
                U.add(i);
            }
        }
        while (U.size()>0)
        {
            int min=Integer.MAX_VALUE;
            int minindex=-1;
            for (int i=0;i<distince.length;i++)
            {
                if(U.contains(i)&&distince[i]<min&&distince[i]>=0)
                {
                    min=distince[i];
                    minindex=i;
                }
            }
            S.add(minindex);
            U.remove(minindex);
            //����distince����
            for (int i=0;i<distince.length;i++)
            {
                if(distince[i]==-1)
                {
                    if(array[minindex][i]!=-1)
                    {
                        distince[i]=distince[minindex]+array[minindex][i];
                    }
                }
                else
                {
                    if(distince[minindex]+array[minindex][i]<distince[i]&&array[minindex][i]!=-1)
                    {
                        distince[i]=distince[minindex]+array[minindex][i];
                    }
                }
            }
        }
        for (int i=0;i<distince.length;i++)
        {
            System.out.println(distince[i]);
        }
    }
    /*
    floyd�㷨�����ÿ������֮�����С���룬˼���Ƕ�̬�滮������Ҫ����distince[i][j]����С����
    ֻ�������������һ����i j ֮�䲻�����κε㣬��Ϊ��С����
    һ����i j ֮�侭����������
    ����distince[i][j]=min(distince[i][k]+distince[k][j],distince[i][j])
    ���湫ʽ��ʹ�õ�ʱ����Ҫע��˳���ڼ���distince[i][j]��ʱ����Ҫ�õ�distince[i][k]��һ��Ҫ��֤
    distince[i][k]�Ѿ������˼��㣬��Ȼ�����׳���distince[i][k] Ϊ��������������ԣ�ʹ��k��Ϊ�����ѭ��
    ʹ��i��Ϊ�ڶ���ѭ����ʹ��j��Ϊ������ѭ��

     */
    public static void floyd(int[][] array)
    {
        int maxValue=1000000;
        int[][] distince=new int[array.length][array.length];
        for (int i=0;i<array.length;i++)
        {
            for (int j=0;j<array.length;j++)
            {
                if(array[i][j]==-1)
                {
                    distince[i][j]=maxValue;
                }
                else
                {
                    distince[i][j]=array[i][j];
                }
            }
        }
        for (int k=0;k<array.length;k++)
        {
            for (int i=0;i<array.length;i++)
            {
                for (int j=0;j<array.length;j++)
                {
                    if(distince[i][j]>distince[i][k]+distince[k][j])
                    {
                        distince[i][j]=distince[i][k]+distince[k][j];
                    }
                }
            }
        }
        for (int i=0;i<distince.length;i++)
        {
            for (int j=0;j<distince.length;j++)
            {
                System.out.print(distince[i][j]+" ");
            }
            System.out.println();
        }
    }
}
