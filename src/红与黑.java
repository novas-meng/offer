import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengfanshan on 2017/7/19.
 * 有一间长方形的房子，地上铺了红色、黑色两种颜色的正方形瓷砖。你站在其中一块黑色的瓷砖上，只能向相邻的（上下左右四个方向）黑色瓷砖移动。请写一个程序，计算你总共能够到达多少块黑色的瓷砖。
 输入描述:
 输入包含多组数据。

 每组数据第一行是两个整数 m 和 n（1≤m, n≤20）。紧接着 m 行，每行包括 n 个字符。每个字符表示一块瓷砖的颜色，规则如下：

 1. “.”：黑色的瓷砖；
 2. “#”：白色的瓷砖；
 3. “@”：黑色的瓷砖，并且你站在这块瓷砖上。该字符在每个数据集合中唯一出现一次。
 输出描述:
 对应每组数据，输出总共能够到达多少块黑色的瓷砖。
 示例1
 输入

 9 6
 ....#.
 .....#
 ......
 ......
 ......
 ......
 ......
 #@...#
 .#..#.
 输出

 45
 */
public class 红与黑 {
    public static int getAccessibleCount(int[][] array,int begin_x,int begin_y,int rows,int cols)
    {
        ArrayList<String> list=new ArrayList<>();
        Queue<String> queue=new LinkedList<>();
        String begin=begin_x+","+begin_y;
        queue.add(begin);
        list.add(begin);
        while (!queue.isEmpty())
        {
            String point=queue.poll();
            String[] var=point.split(",");
            int point_x=Integer.valueOf(var[0]);
            int point_y=Integer.valueOf(var[1]);
            String new_point=null;
            //上面满足情况
            if(point_x-1>=0&&array[point_x-1][point_y]==1)
            {
                new_point=(point_x-1)+","+point_y;
                if(!list.contains(new_point))
                {
                    list.add(new_point);
                    queue.add(new_point);
                }
            }
            //下面满足情况
            if(point_x+1<rows&&array[point_x+1][point_y]==1)
            {
                new_point=(point_x+1)+","+point_y;
                if(!list.contains(new_point))
                {
                    list.add(new_point);
                    queue.add(new_point);
                }
            }
            //左面满足情况
            if(point_y-1>=0&&array[point_x][point_y-1]==1)
            {
                new_point=(point_x)+","+(point_y-1);
                if(!list.contains(new_point))
                {
                    list.add(new_point);
                    queue.add(new_point);
                }
            }
            //右面满足情况
            if(point_y+1<cols&&array[point_x][point_y+1]==1)
            {
                new_point=(point_x)+","+(point_y+1);
                if(!list.contains(new_point))
                {
                    list.add(new_point);
                    queue.add(new_point);
                }
            }

        }
        System.out.println(list.size());
        return 0;
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String line=bufferedReader.readLine();
        while (line!=null)
        {
            String[] var=line.split(" ");
            int rows=Integer.valueOf(var[0]);
            int cols=Integer.valueOf(var[1]);
            int[][] array=new int[rows][cols];
            int begin_x=0;
            int begin_y=0;
            for (int i=0;i<rows;i++)
            {
                String str=bufferedReader.readLine();
                char[] chars=str.toCharArray();
                for (int j=0;j<chars.length;j++)
                {
                    if(chars[j]=='.')
                    {
                        array[i][j]=1;
                    }
                    else if(chars[j]=='#')
                    {
                        array[i][j]=0;
                    }
                    else
                    {
                        begin_x=i;
                        begin_y=j;
                    }
                }
            }
            for (int i=0;i<rows;i++)
            {
                for (int j=0;j<cols;j++)
                {
                   // System.out.print(array[i][j]+",");
                }
                //System.out.println();
            }
            System.out.println(begin_x+","+begin_y);
            getAccessibleCount(array,begin_x,begin_y,rows,cols);
            line=bufferedReader.readLine();
        }
    }
}
