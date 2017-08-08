import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by mengfanshan on 2017/7/19.
 * NowCoder最喜欢游乐场的迷宫游戏，他和小伙伴们比赛谁先走出迷宫。
 现在把迷宫的地图给你，你能帮他算出最快走出迷宫需要多少步吗？
 输入描述:
 输入包含多组数据。

 每组数据包含一个10*10，由“#”和“.”组成的迷宫。其中“#”代表墙；“.”代表通路。

 入口在第一行第二列；出口在最后一行第九列。

 从任意一个“.”点都能一步走到上下左右四个方向的“.”点。
 输出描述:
 对应每组数据，输出从入口到出口最短需要几步。
 示例1
 输入

 #.########
 #........#
 #........#
 #........#
 #........#
 #........#
 #........#
 #........#
 #........#
 ########.#
 #.########
 #........#
 ########.#
 #........#
 #.########
 #........#
 ########.#
 #........#
 #.######.#
 ########.#
 输出

 16
 30
 */
public class 走迷宫 {
    public static int getCount(char[][] array)
    {
        String begin="0,1";
        String end="9,8";
        //存储已经访问的节点
        Set<String> visit=new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        queue.add(begin);
        int count=0;
        while (true)
        {
            Queue<String> temp=new LinkedList<>();
            while (!queue.isEmpty())
            {
                String xy_point=queue.poll();
                if(xy_point.equals(end))
                {
                    return count;
                }
                visit.add(xy_point);
                String[] xy=xy_point.split(",");
                int _x=Integer.valueOf(xy[0]);
                int _y=Integer.valueOf(xy[1]);
                //上面可以通过
                if(_x-1>=0&&array[_x-1][_y]=='.'&&!visit.contains((_x-1)+","+_y))
                {
                    if(!temp.contains((_x-1)+","+_y))
                    {
                        temp.add((_x-1)+","+_y);
                    }
                }
                //下面可以通过
                if(_x+1<=9&&array[_x+1][_y]=='.'&&!visit.contains((_x+1)+","+_y))
                {
                    if(!temp.contains((_x+1)+","+_y))
                    {
                        temp.add((_x+1)+","+_y);
                    }
                }
                //左面可以通过
                if(_y-1>=0&&array[_x][_y-1]=='.'&&!visit.contains((_x)+","+(_y-1)))
                {
                    if(!temp.contains((_x)+","+(_y-1)))
                    {
                        temp.add((_x)+","+(_y-1));
                    }
                }
                //右面可以通过

                if(_y+1<=9&&array[_x][_y+1]=='.'&&!visit.contains((_x)+","+(_y+1)))
                {
                    if(!temp.contains((_x)+","+(_y+1)))
                    {
                        temp.add((_x)+","+(_y+1));
                    }
                }

            }
            if(temp.isEmpty())
            {
                break;
            }
            else
            {
                queue.clear();
                queue.addAll(temp);
                count++;
            }
        }
        return 0;
    }
    public static void main(String[] args)throws IOException
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            char[][] array=new char[10][10];
            for (int i=0;i<10;i++)
            {
                array[i]=scanner.nextLine().toCharArray();
            }
            System.out.println(getCount(array));
        }
    }
}
