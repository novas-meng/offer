/**
 * Created by mengfanshan on 2017/7/15.
 *
 ���֮�£����ܷɡ������й�����ţ�У����ν����������ꡱ��
 ����һ���ع���ʷ�Ļ��ᣬ��֪һ֧��Ʊ����n��ļ۸����ƣ�
 �Գ���Ϊn�����������ʾ�������е�i��Ԫ�أ�prices[i]������ù�Ʊ��i��Ĺɼۡ�
 ������һ��ʼû�й�Ʊ������������������1�ɶ�������1�ɵĻ��ᣬ��������ǰһ��Ҫ�ȱ�֤����û�й�Ʊ��
 �����ν��׻��ᶼ����������Ϊ0�� ����㷨���������ܻ�õ�������档
 ������ֵ��Χ��2<=n<=100,0<=prices[i]<=100
 ʾ��1
 ����

 3,8,5,1,7,8
 ���

 12
 */
public class calculateMax {
    public static void main(String[] args)
    {
        int[] array={31,41};
        System.out.println(calculateMax(array));
    }
    public static int getMax(int[] array,int begin,int end)
    {
        int[] max=new int[end-begin+1];
        for (int i=begin+1;i<=end;i++)
        {
            int minus=array[i]-array[i-1];
            int maxminus=Math.max(minus,minus+max[i-begin-1]);
            max[i-begin]=maxminus;
        }
        int res=0;
        for (int i=0;i<max.length;i++)
        {
            if(max[i]>res)
            {
                res=max[i];
            }
        }
        System.out.println(res);
        return res;
    }
    public static int calculateMax(int[] prices) {
        int maxsum=0;
        for (int i=0;i<prices.length;i++)
        {
            int sum=getMax(prices,0,i)+getMax(prices,i+1,prices.length-1);
            if(sum>maxsum)
            {
                maxsum=sum;
            }
        }
        return maxsum;
    }
}
