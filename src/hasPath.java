import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by mengfanshan on 2017/7/12.
 * 请设计一个函数，
 * 用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，
 * 向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，
 * 则该路径不能再进入该格子。 例如 a b c e s f c s a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */
public class hasPath {
    public static void main(String[] args)
    {
        String t="ABCESFCSADEE";
        char[] martix=t.toCharArray();
        String s=new String("ABCB");
        hasPath(martix,3,4,s.toCharArray());
    }
    public static void setArray(int[] array,int k,int j,int rows,int cols)
    {
        if(k==0)
        {
            array[2]=1;
        }
        if(k==rows-1)
        {
            array[3]=1;
        }
        if(j==0)
        {
            array[0]=1;
        }
        if(j==cols-1)
        {
            array[1]=1;
        }
    }
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        char[][] matrix_new=new char[rows][cols];
        int index=0;
        for (int i=0;i<rows;i++)
        {
            for (int j=0;j<cols;j++)
            {
                matrix_new[i][j]=matrix[index];
                index++;
            }
        }
        Stack<int[]> stack=new Stack<>();
        int[] res=new int[2];
        res[0]=-1;
        res[1]=-1;
        stack.add(res);
        Stack<String> path=new Stack<>();
        Stack<String> headpath=new Stack<>();
        //index 0 表示左，index 1 表示 右 2 表示 上 3 表示 下 为1 表示不能使用那个方向
        int[][] weizhi=new int[matrix.length][4];
        for (int i=0;i<str.length;i++)
        {
            int[] s=stack.peek();
            System.out.println("s[0]="+s[0]+","+str[i]);
            if(s[0]==-1)
            {
                int flag=0;
                for (int k=0;k<rows;k++)
                {
                    for (int j=0;j<cols;j++)
                    {
                        if(matrix_new[k][j]==str[i]&&!path.contains(k+","+j)&&!headpath.contains(k+","+j))
                        {
                            headpath.add(k+","+j);
                            System.out.println("k="+k+",l="+j);
                            int[] var=new int[2];
                            var[0]=k;
                            var[1]=j;
                            stack.add(var);
                            int v=k*cols+j;
                            System.out.println("v="+v);
                            setArray(weizhi[v],k,j,rows,cols);
                            System.out.println(weizhi[v][0]+","+weizhi[v][1]+","+weizhi[v][2]+","+weizhi[v][3]);
                            path.add(k+","+j);
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                        break;
                }
            }
            else
            {
                int loc=s[0]*cols+s[1];
                System.out.println("loc="+loc+","+s[0]+","+s[1]);
                int[] w=weizhi[loc];
                if(w[0]==0&&matrix_new[s[0]][s[1]-1]==str[i]&&!path.contains(s[0]+","+(s[1]-1)))
                {
                    int[] v=new int[2];
                    v[0]=s[0];
                    v[1]=s[1]-1;
                    w[0]=1;
                    stack.add(v);
                    path.add(s[0]+","+(s[1]-1));
                    int vv=v[0]*cols+v[1];
                    setArray(weizhi[vv],v[0],v[1],rows,cols);

                }
                else if(w[1]==0&&matrix_new[s[0]][s[1]+1]==str[i]&&!path.contains(s[0]+","+(s[1]+1)))
                {
                    int[] v=new int[2];
                    v[0]=s[0];
                    v[1]=s[1]+1;
                    w[1]=1;
                    stack.add(v);
                    path.add(s[0]+","+(s[1]+1));
                    int vv=v[0]*cols+v[1];
                    setArray(weizhi[vv],v[0],v[1],rows,cols);

                }
                else if(w[2]==0&&matrix_new[s[0]-1][s[1]]==str[i]&&!path.contains((s[0]-1)+","+(s[1])))
                {
                    int[] v=new int[2];
                    v[0]=s[0]-1;
                    v[1]=s[1];
                    w[2]=1;
                    stack.add(v);
                    path.add((s[0]-1)+","+(s[1]));
                    int vv=v[0]*cols+v[1];
                    setArray(weizhi[vv],v[0],v[1],rows,cols);

                }
                else if(w[3]==0&&matrix_new[s[0]+1][s[1]]==str[i]&&!path.contains((s[0]+1)+","+(s[1])))
                {
                    int[] v=new int[2];
                    v[0]=s[0]+1;
                    v[1]=s[1];
                    w[3]=1;
                    stack.add(v);
                    path.add((s[0]+1)+","+(s[1]));
                    int vv=v[0]*cols+v[1];
                    setArray(weizhi[vv],v[0],v[1],rows,cols);

                }
                else
                {
                    weizhi[loc]=new int[4];
                    stack.pop();
                    path.pop();
                    i=i-2;
                }
            }
        }
        System.out.println(path.size());
        System.out.println(path);
        if(path.size()==str.length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
