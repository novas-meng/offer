/**
 * Created by mengfanshan on 2017/7/6.
 */
public class Add {
    /*
        写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     */
    public static void main(String[] args)
    {
        System.out.println(Add(-10,4));
    }
    public static int Add(int num1,int num2) {
        int a=num1;
        int b=num2;
        int jinwei=0;
        int sum=0;
        int danwei=1;
        for (int i=0;i<32;i++)
        {
            int a1=a&1;
            int b1=b&1;
            int newjinwei=(a1&b1)|((a|b)&jinwei);
            //System.out.println(newjinwei);
            int left=a1^b1^jinwei;
            //System.out.println(left);
            sum=sum+left*danwei;
            danwei=danwei*2;
            jinwei=newjinwei;
            a=a>>1;
            b=b>>1;
        }
        sum=sum+danwei*jinwei;
        return sum;
    }
}
