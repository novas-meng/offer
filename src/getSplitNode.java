import java.util.*;


/**
 * Created by mengfanshan on 2017/7/15.
 * git��һ�ֲַ�ʽ��������ߣ�
 * gitͨ��������ʽ��¼�ļ��ĸ�����ʷ��
 * ���磺 base'<--base<--A<--A' ^ | --- B<--B'
 * С�׹���ʦ������ҪѰ��������֧����ķָ�㣬
 * ��base.����git ���Ƕ��������ʵ��һ���㷨��
 * ����git�����������������ָ�㡣
 * ������git���ڵ���Ϊn,���ڽӾ������ʽ��ʾgit����
 * �ַ�������matrix����n���ַ�����ÿ���ַ������ַ�'0'��'1'��ɣ�
 * ����Ϊn��matrix[i][j]=='1'���ҽ���git���ֵ�i���͵�j���ڵ������ӡ�
 * �ڵ�0Ϊgit���ĸ��ڵ㡣��
 * ����

 [01011,10100,01000,10000,10000],1,2
 ���

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
     * ����git�������������ָ��
     *
     * @param matrix ���ھ��󣬱�ʾgit����matrix[i][j] == '1' ���ҽ���git���е�i���͵�j���ڵ������ӣ��ڵ�0Ϊgit���ĸ��ڵ�
     * @param indexA �ڵ�A��index
     * @param indexB �ڵ�B��index
     * @return ����
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
