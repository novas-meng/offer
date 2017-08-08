import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengfanshan on 2017/7/19.
 * ��һ�䳤���εķ��ӣ��������˺�ɫ����ɫ������ɫ�������δ�ש����վ������һ���ɫ�Ĵ�ש�ϣ�ֻ�������ڵģ����������ĸ����򣩺�ɫ��ש�ƶ�����дһ�����򣬼������ܹ��ܹ�������ٿ��ɫ�Ĵ�ש��
 ��������:
 ��������������ݡ�

 ÿ�����ݵ�һ������������ m �� n��1��m, n��20���������� m �У�ÿ�а��� n ���ַ���ÿ���ַ���ʾһ���ש����ɫ���������£�

 1. ��.������ɫ�Ĵ�ש��
 2. ��#������ɫ�Ĵ�ש��
 3. ��@������ɫ�Ĵ�ש��������վ������ש�ϡ����ַ���ÿ�����ݼ�����Ψһ����һ�Ρ�
 �������:
 ��Ӧÿ�����ݣ�����ܹ��ܹ�������ٿ��ɫ�Ĵ�ש��
 ʾ��1
 ����

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
 ���

 45
 */
public class ����� {
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
            //�����������
            if(point_x-1>=0&&array[point_x-1][point_y]==1)
            {
                new_point=(point_x-1)+","+point_y;
                if(!list.contains(new_point))
                {
                    list.add(new_point);
                    queue.add(new_point);
                }
            }
            //�����������
            if(point_x+1<rows&&array[point_x+1][point_y]==1)
            {
                new_point=(point_x+1)+","+point_y;
                if(!list.contains(new_point))
                {
                    list.add(new_point);
                    queue.add(new_point);
                }
            }
            //�����������
            if(point_y-1>=0&&array[point_x][point_y-1]==1)
            {
                new_point=(point_x)+","+(point_y-1);
                if(!list.contains(new_point))
                {
                    list.add(new_point);
                    queue.add(new_point);
                }
            }
            //�����������
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
