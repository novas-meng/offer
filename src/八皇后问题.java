import com.sun.org.glassfish.external.statistics.Statistic;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

/**
 * Created by mengfanshan on 2017/7/31.
 * ���¹���������˶��������
 * �ʺ�����ںᡢ����б���ϲ��޲����سԵ��������ӡ�
 * ��ν� 8 ���ʺ���������ϣ���8��8�����񣩣�
 * ʹ����˭Ҳ���ܱ��Ե�������������İ˻ʺ����⡣
 ����ĳ������Ҫ���8�ʺ�İڷŷ���������һ���ʺ�a��֮��Ӧ��
 �� a=b1b2...b8, ����bi��1��bi��8��Ϊ��Ӧ�ڷ��е� i �лʺ�������������
 �Ѿ�֪��8�ʺ�����һ����92��⣨��92����ͬ�Ļʺ󴮣�������һ����n��Ҫ�������n������
 ���ıȽ���������:�ʺ�x���ڻʺ�y֮ǰ�����ҽ�����x��Ϊ����ʱ��yС��
 ��������:
 ��������������ݡ�

 ÿ�����ݰ���һ��������n��1��n��92����
 �������:
 ��Ӧÿһ�����룬�����n���ʺ󴮡�
 ʾ��1
 ����

 1
 92
 ���

 15863724
 84136275
 */

public class �˻ʺ����� {

    /*
    ˼·����ȡ8�ʺ���ܵ��������У����Ƚ��з����������ҿ��ܵ�����£��ӵ�һ�е���8�У�ÿһ�ж�������һ���ʺ�
    ��ô���ǿ��Դӵ�һ�е�һ�п�ʼ�������������������еĿ��������Ȼ���ڱ�ɵ�һ�еڶ��У�Ȼ���ڼ���������������п������
    ���ظ��������̣�ֱ�����е���һ�еڰ���Ϊֹ



     */
    public static int getAllCount(int rows,int cols,int index)
    {
        //ʹ��hashmap �洢���Թ�ʹ�õ�λ�ã�key��ʾ�У�value��ʾ�������Ѿ�ʹ�õ���
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
                ʹ�ö�ջ���д洢���洢����ÿһ����ѡȡ���б��
                 */
                Stack<Integer> integersqueue=new Stack<>();
                integersqueue.addAll(stack);
                //
                /*
                �������洢�ţ���Ӧ��ÿ�еģ�����ʹ�õ��У���Ϊ��ÿ������Ԫ�ص�ʱ����Ҫ�����ж�
                �жϷ����ǣ����ݶ�ջ�е�Ԫ�أ�ÿ��Ԫ�صĺᣬ����б�ߣ��ǲ����Ե�

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
                    //��������
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
