/**
 * Created by mengfanshan on 2017/7/7.
 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ�
 * ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
 * Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 */
public class duplicate {
    public static void main(String[] args)
    {
        int[] array={2,1,3,0,4};
        duplicate(array,array.length,new int[1]);
    }

    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||numbers.length==0)
        {
            duplication[0]=-1;
            return false;
        }
        for (int begin=0;begin<length;begin++)
        {
            System.out.println(begin);
            if(numbers[begin]<0)
                continue;
            int newindex=numbers[begin];
            if(newindex==begin)
            {
                numbers[begin]=-1;
                continue;
            }
            if(numbers[newindex]<0)
            {
                numbers[newindex]--;
            }
            while (true)
            {

                System.out.println("newindex="+newindex);
                int nextindex=numbers[newindex];

                if(numbers[newindex]<=0)
                {
                    numbers[newindex]--;
                }
                else
                {
                    numbers[newindex]=-1;
                }
                if(newindex==0)
                {
                    break;
                }
                newindex=nextindex;
                if(nextindex<0)
                {
                    break;
                }
            }
        }
        for (int i=0;i<numbers.length;i++)
        {
            System.out.println(numbers[i]);
            if(numbers[i]<-1)
            {
                duplication[0]=i;
                return true;
            }
        }
        return false;
    }
}
