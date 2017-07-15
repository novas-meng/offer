import java.util.*;


/**
 * Created by mengfanshan on 2017/7/15.
 * git是一种分布式代码管理工具，
 * git通过树的形式记录文件的更改历史，
 * 比如： base'<--base<--A<--A' ^ | --- B<--B'
 * 小米工程师常常需要寻找两个分支最近的分割点，
 * 即base.假设git 树是多叉树，请实现一个算法，
 * 计算git树上任意两点的最近分割点。
 * （假设git树节点数为n,用邻接矩阵的形式表示git树：
 * 字符串数组matrix包含n个字符串，每个字符串由字符'0'或'1'组成，
 * 长度为n。matrix[i][j]=='1'当且仅当git树种第i个和第j个节点有连接。
 * 节点0为git树的根节点。）
 * 输入

 [01011,10100,01000,10000,10000],1,2
 输出

 1
 */

public class getSplitNode {
    public static void main(String[] args)
    {
        String[] var={"01001","10100","01000","00001","10010"};
        System.out.println(getSplitNode(var,3,4));
    }
    public static ArrayList<Integer> getPath(int[] parent,int begin)
    {
        ArrayList<Integer> list=new ArrayList<>();
        while (begin!=-1)
        {
            list.add(begin);
            begin=parent[begin];
        }
        return list;
    }
    /**
     * 返回git树上两点的最近分割点
     *
     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 当且仅当git树中第i个和第j个节点有连接，节点0为git树的跟节点
     * @param indexA 节点A的index
     * @param indexB 节点B的index
     * @return 整型
     */
    public static int getSplitNode(String[] matrix, int indexA, int indexB) {
        if(indexA==indexB)
        {
            return indexA;
        }
        int[][] new_martix=new int[matrix.length][matrix.length];
        for (int i=0;i<matrix.length;i++)
        {
            char[] chars=matrix[i].toCharArray();
            int[] temp=new int[chars.length];
            for (int j=0;j<chars.length;j++)
            {
                temp[j]=chars[j]-48;
            }
            new_martix[i]=temp;
        }
        int[] parent=new int[matrix.length];
        for (int i=0;i<parent.length;i++)
        {
            parent[i]=-1;
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty())
        {
            int p=queue.poll();
           // System.out.println(p);
            int[] pp=new_martix[p];
            for (int i=0;i<pp.length;i++)
            {
               // System.out.println(pp[i]);
                if(pp[i]==1)
                {
                    if(parent[p]!=i)
                    {
                        parent[i]=p;
                        queue.add(i);
                    }
                }
            }
        }

        ArrayList<Integer>  A=getPath(parent,indexA);
        ArrayList<Integer>  B=getPath(parent,indexB);

        int i=A.size()-1;
        int j=B.size()-1;
        int same=0;
        while (i>=0&&j>=0&&A.get(i)==B.get(j))
        {
            same=A.get(i);
            i--;
            j--;

        }
        return same;
    }
}
