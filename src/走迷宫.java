import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by mengfanshan on 2017/7/19.
 * NowCoder��ϲ�����ֳ����Թ���Ϸ������С����Ǳ���˭���߳��Թ���
 ���ڰ��Թ��ĵ�ͼ���㣬���ܰ����������߳��Թ���Ҫ���ٲ���
 ��������:
 ��������������ݡ�

 ÿ�����ݰ���һ��10*10���ɡ�#���͡�.����ɵ��Թ������С�#������ǽ����.������ͨ·��

 ����ڵ�һ�еڶ��У����������һ�еھ��С�

 ������һ����.���㶼��һ���ߵ����������ĸ�����ġ�.���㡣
 �������:
 ��Ӧÿ�����ݣ��������ڵ����������Ҫ������
 ʾ��1
 ����

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
 ���

 16
 30
 */
public class ���Թ� {
    public static int getCount(char[][] array)
    {
        String begin="0,1";
        String end="9,8";
        //�洢�Ѿ����ʵĽڵ�
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
                //�������ͨ��
                if(_x-1>=0&&array[_x-1][_y]=='.'&&!visit.contains((_x-1)+","+_y))
                {
                    if(!temp.contains((_x-1)+","+_y))
                    {
                        temp.add((_x-1)+","+_y);
                    }
                }
                //�������ͨ��
                if(_x+1<=9&&array[_x+1][_y]=='.'&&!visit.contains((_x+1)+","+_y))
                {
                    if(!temp.contains((_x+1)+","+_y))
                    {
                        temp.add((_x+1)+","+_y);
                    }
                }
                //�������ͨ��
                if(_y-1>=0&&array[_x][_y-1]=='.'&&!visit.contains((_x)+","+(_y-1)))
                {
                    if(!temp.contains((_x)+","+(_y-1)))
                    {
                        temp.add((_x)+","+(_y-1));
                    }
                }
                //�������ͨ��

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
