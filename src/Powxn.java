/**
 * Created by mengfanshan on 2017/8/13.
 * Implement pow(x, n).
 */
public class Powxn {
    public static void main(String[] args)
    {
        System.out.println(myPow(2.0,-2147483648));
    }
    public static double myPow(double x, int n) {
        if(n<0)
        {
            n=-n;
            x=1/x;
        }
        if(n==1)
        {
            return x;
        }
        if(n==0)
        {
            return 1;
        }
        if(n%2==0)
        {
            double res=myPow(x,n/2);
            if(res>Double.MAX_VALUE)
            {
                return 0;
            }
            return res*res;
        }
        else
        {
            double res=myPow(x,n/2);
            if(res>Double.MAX_VALUE)
            {
                return 0;
            }
            return res*res*x;
        }
    }

}
