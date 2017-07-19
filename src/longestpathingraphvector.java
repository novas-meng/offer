import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengfanshan on 2017/7/19.
 * 求无环有向图中的最长路径
 * 使用动态规划算法进行求解，
 * 使用distance（i) 表示末尾节点是i的最长路径的长度
 * 对于节点A来说，假设b c 指向 A
 * 那么末尾节点为A的最长路径长度
 * distance(A)=max(distance(b)+array[b][a],distance(c)+array[c][a])
 * 上面那个公式主要的问题是，如何确定先计算那些节点，才能保证在计算A的时候，前置节点已经计算完毕
 * 这个时候可以考虑使用拓扑排序
 * 首先计算入度为0的，然后进行删除链接节点，得到新的入度为0的节点，重复上述步骤
 *
 */
public class longestpathingraphvector {
    public static void main(String[] args)
    {
        int[][] array=new int[6][6];
        array[0][1]=1;
        array[1][2]=1;
        array[2][4]=1;
        array[2][5]=1;
        array[3][1]=1;
        array[3][4]=1;
        array[4][5]=1;
        System.out.println(getLongestPath(array));

    }
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
            distince[node]=-1;
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
}
