import java.util.Stack;

/**
 * Created by mengfanshan on 2017/7/13.
 */
public class movingCount {
    public static void main(String[] args)
    {
        System.out.println(movingCount(15,20,20));
    }
    //k j 行 列
    public static void setArray(int[] array,int k,int j,int rows,int cols)
    {
        if(k==0)
        {
            array[3]=1;
        }
        if(k==rows-1)
        {
            array[2]=1;
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

    public static boolean getNodeOK(int i,int j,int threadhold)
    {

        String s=i+""+j+"";
        char[] chars=s.toCharArray();
        int sum=0;
        for (int k=0;k<chars.length;k++)
        {
            sum=sum+chars[k]-48;
        }
        if(sum<=threadhold)
            return true;
        return false;
    }
    public static int movingCount(int threshold, int rows, int cols)
    {
        int[][] martix=new int[rows][cols];
        martix[0][0]=1;
        int all=rows*cols;
        //        //index 0 表示左，index 1 表示 右 2 表示 上 3 表示 下 为1 表示不能使用那个方向
        int[][] weizhi=new int[all][4];
        int[] point=new int[2];
        point[0]=0;
        point[0]=0;
        Stack<int[]> stack=new Stack<>();
        stack.add(point);
        setArray(weizhi[0],0,0,rows,cols);
        while (!stack.isEmpty())
        {
            int[] current=stack.peek();
            //System.out.println(current[0]+","+current[1]);
            int loc=current[0]*cols+current[1];
            int[] var=weizhi[loc];
            //System.out.println("var="+var[0]+","+var[1]+","+var[2]+","+var[3]);
            if(var[0]==0&&getNodeOK(current[0],current[1]-1,threshold))
            {
                int[] next=new int[2];
                next[0]=current[0];
                next[1]=current[1]-1;
                stack.add(next);
                int nextloc=next[0]*cols+next[1];
                setArray(weizhi[nextloc],next[0],next[1],rows,cols);
                martix[next[0]][next[1]]=1;
                var[0]=1;
            }
            else if(var[1]==0&&getNodeOK(current[0],current[1]+1,threshold))
            {
                int[] next=new int[2];
                next[0]=current[0];
                next[1]=current[1]+1;
                stack.add(next);
                int nextloc=next[0]*cols+next[1];
                //System.out.println("nextLoc="+nextloc);
                setArray(weizhi[nextloc],next[0],next[1],rows,cols);
                martix[next[0]][next[1]]=1;
                var[1]=1;
            }
            else if(var[2]==0&&getNodeOK(current[0]+1,current[1],threshold))
            {
                int[] next=new int[2];
                next[0]=current[0]+1;
                next[1]=current[1];
                stack.add(next);
                int nextloc=next[0]*cols+next[1];
                setArray(weizhi[nextloc],next[0],next[1],rows,cols);
                martix[next[0]][next[1]]=1;
                var[2]=1;
            }
            else if(var[3]==0&&getNodeOK(current[0]-1,current[1],threshold))
            {
                int[] next=new int[2];
                next[0]=current[0]-1;
                next[1]=current[1];
                stack.add(next);
                int nextloc=next[0]*cols+next[1];
                setArray(weizhi[nextloc],next[0],next[1],rows,cols);
                martix[next[0]][next[1]]=1;
                var[3]=1;
            }
            else
            {
                stack.pop();
            }
        }
        int count=0;
        for (int i=0;i<rows;i++)
        {
            for (int j=0;j<cols;j++)
            {
                if(martix[i][j]==1&&getNodeOK(i,j,threshold))
                {
                    count++;
                }
            }
        }
        return count;
    }

}
