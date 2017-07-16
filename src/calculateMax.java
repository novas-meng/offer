/**
 * Created by mengfanshan on 2017/7/15.
 *
 风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。
 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，
 以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。
 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。
 若两次交易机会都放弃，收益为0。 设计算法，计算你能获得的最大收益。
 输入数值范围：2<=n<=100,0<=prices[i]<=100
 示例1
 输入

 3,8,5,1,7,8
 输出

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
