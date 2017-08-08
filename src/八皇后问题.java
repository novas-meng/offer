import com.sun.org.glassfish.external.statistics.Statistic;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

/**
 * Created by mengfanshan on 2017/7/31.
 * 会下国际象棋的人都很清楚：
 * 皇后可以在横、竖、斜线上不限步数地吃掉其他棋子。
 * 如何将 8 个皇后放在棋盘上（有8×8个方格），
 * 使它们谁也不能被吃掉！这就是著名的八皇后问题。
 对于某个满足要求的8皇后的摆放方法，定义一个皇后串a与之对应，
 即 a=b1b2...b8, 其中bi（1≤bi≤8）为相应摆法中第 i 行皇后所处的列数。
 已经知道8皇后问题一共有92组解（即92个不同的皇后串）。给出一个数n，要求输出第n个串。
 串的比较是这样的:皇后串x置于皇后串y之前，当且仅当将x视为整数时比y小。
 输入描述:
 输入包含多组数据。

 每组数据包含一个正整数n（1≤n≤92）。
 输出描述:
 对应每一组输入，输出第n个皇后串。
 示例1
 输入

 1
 92
 输出

 15863724
 84136275
 */

public class 八皇后问题 {

    /*
    思路：获取8皇后可能的所有序列，首先进行分析，在左右可能的情况下，从第一行到第8行，每一行都必须有一个皇后。
    那么我们可以从第一列第一行开始，计算这种条件下所有的可能情况，然后在变成第一列第二行，然后在计算这种情况下所有可能情况
    ，重复上述过程，直到进行到第一列第八行为止



     */
    public static int getAllCount(int rows,int cols,int index)
    {
        //使用hashmap 存储可以供使用的位置，key表示行，value表示该行中已经使用的列
        /*


         */
        HashMap<Integer,ArrayList<Integer>> visitedmap=new HashMap<>();
        int nowindex=1;
        for (int i=0;i<cols;i++)
        {
            Stack<Integer> stack=new Stack<>();
            stack.add(i);

            while (!stack.isEmpty())
            {
                /*
                使用堆栈进行存储，存储的是每一行中选取的列编号
                 */
                Stack<Integer> integersqueue=new Stack<>();
                integersqueue.addAll(stack);
                //
                /*
                这个数组存储着，对应于每行的，可以使用的列，因为在每次增加元素的时候，需要进行判断
                判断方法是，根据堆栈中的元素，每个元素的横，竖，斜线，是不可以的

                 */

                int[] indexarray=new int[cols];
                int count=1;
                while (!integersqueue.isEmpty())
                {
                    int current=integersqueue.pop();
                    //System.out.println("current="+current+","+count+","+count);
                    if(current-count>=0)
                    {
                        indexarray[current-count]=1;
                    }
                    indexarray[current]=1;
                    if(current+count<cols)
                    {
                        indexarray[current+count]=1;
                    }
                    count++;
                }
                int canchoose=-1;
                for (int j=0;j<indexarray.length;j++)
                {
                    if(indexarray[j]==0)
                    {
                        if(visitedmap.containsKey(stack.size()+1))
                        {
                            if(!visitedmap.get(stack.size()+1).contains(j))
                            {
                                canchoose=j;
                                break;
                            }
                        }
                        else
                        {
                            canchoose=j;
                            break;
                        }
                    }
                }
               // System.out.println("canchoose="+canchoose+",size="+stack.size()+"  "+stack);
                if(canchoose==-1)
                {
                    if(visitedmap.containsKey(stack.size()+1))
                    {
                        visitedmap.remove(stack.size()+1);
                    }
                    stack.pop();
                }
                else
                {
                    stack.add(canchoose);
                    //满足条件
                    if(!visitedmap.containsKey(stack.size()))
                    {
                        ArrayList<Integer> list=new ArrayList<>();
                        list.add(canchoose);
                        visitedmap.put(stack.size(),list);
                    }
                    else
                    {
                        ArrayList<Integer> list=visitedmap.get(stack.size());
                        list.add(canchoose);
                        visitedmap.put(stack.size(),list);
                    }

                    if(stack.size()==rows)
                    {
                        //System.out.println(stack);
                        if(nowindex==index)
                        {
                            int _10=1;
                            int sum=0;
                            while (!stack.isEmpty())
                            {
                                sum=sum+(stack.pop()+1)*_10;
                                _10=_10*10;
                            }
                           // System.out.println(sum);
                            return sum;
                        }
                        nowindex++;
                        if(visitedmap.containsKey(stack.size()+1))
                        {
                            visitedmap.remove(stack.size()+1);
                        }
                        stack.pop();
                    }
                }
                //System.out.println("size="+stack.size());
            }
        }
        return 0;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int index=scanner.nextInt();
            System.out.println(getAllCount(8,8,index));
        }
    }
}
