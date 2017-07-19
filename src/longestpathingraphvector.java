import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengfanshan on 2017/7/19.
 * ���޻�����ͼ�е��·��
 * ʹ�ö�̬�滮�㷨������⣬
 * ʹ��distance��i) ��ʾĩβ�ڵ���i���·���ĳ���
 * ���ڽڵ�A��˵������b c ָ�� A
 * ��ôĩβ�ڵ�ΪA���·������
 * distance(A)=max(distance(b)+array[b][a],distance(c)+array[c][a])
 * �����Ǹ���ʽ��Ҫ�������ǣ����ȷ���ȼ�����Щ�ڵ㣬���ܱ�֤�ڼ���A��ʱ��ǰ�ýڵ��Ѿ��������
 * ���ʱ����Կ���ʹ����������
 * ���ȼ������Ϊ0�ģ�Ȼ�����ɾ�����ӽڵ㣬�õ��µ����Ϊ0�Ľڵ㣬�ظ���������
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
        //�洢ĩβ�ڵ�Ϊi���·���ĳ���
        int[] maxpath=new int[array.length];
        while (!_zeroQueue.isEmpty())
        {
            int node = _zeroQueue.poll();
            distince[node]=-1;
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
