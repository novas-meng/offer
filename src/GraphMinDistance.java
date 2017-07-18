import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengfanshan on 2017/7/18.
 * 输入是邻接矩阵的形式，求无向图的单源最短路径和多源最短路径
 * 分别使用dijkstra算法和floyd算法
 * 连接http://www.cnblogs.com/biyeymyhjob/archive/2012/07/31/2615833.html
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
      dijkstra算法，求0节点到其余节点的最短距离，首先初始化一个数组distince，表示0节点到其余所有节点的距离
      然后初始化两个集合S和U，S为已经确定最短距离的点集合，U为其余所有点的结合
      首先从distince数组中选出路径长度最小的那个节点A，其中A需要满足A在集合U中，然后将A加入集合S
      更新distince数组，具体更新策略为
      假设新加入的是节点1，那么对于每个节点计算如果经过1节点，即0-1-相应的节点的距离 和0-相应节点的距离 取最小值进行更新
      distince数组，重复上述步骤

     */
//顶点序号 0,1,2,....array.length-1
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
            //更新distince数组
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
    floyd算法，求出每两个点之间的最小距离，思想是动态规划，比如要计算distince[i][j]的最小距离
    只能有两种情况，一种是i j 之间不经过任何点，即为最小距离
    一种是i j 之间经过了其他点
    所以distince[i][j]=min(distince[i][k]+distince[k][j],distince[i][j])
    上面公式在使用的时候需要注意顺序，在计算distince[i][j]的时候，需要用到distince[i][k]，一定要保证
    distince[i][k]已经经过了计算，不然很容易出现distince[i][k] 为无穷大的情况，所以，使用k作为最外层循环
    使用i作为第二层循环，使用j作为第三层循环

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
