/**
 * Created by mengfanshan on 2017/8/8.
 */
public class StringtoInteger {
    public static int myAtoi(String str) {
        char[] chars=str.toCharArray();
        int base=1;
        int sum=0;
        if(chars.length==0)
        {
            return 0;
        }
        if(chars[0]=='+')
        {
            for (int i=chars.length-1;i>=1;i--)
            {
                if(chars[i]-48<0)
                {
                    sum=0;
                    break;
                }
                sum=sum+base*(chars[i]-48);
                base=base*10;
            }
        }
        else if(chars[0]=='-')
        {
            for (int i=chars.length-1;i>=1;i--)
            {
                if(chars[i]-48<0)
                {
                    sum=0;
                    break;
                }
                sum=sum+base*(chars[i]-48);
                base=base*10;
            }
            sum=-sum;
        }
        else
        {

            for (int i=chars.length-1;i>=0;i--)
            {
                sum=sum+base*(chars[i]-48);
                base=base*10;
            }
        }
        return sum;
    }
    public static void main(String[] args)
    {
        System.out.println(myAtoi("+-2"));
        System.out.println((int)'-');
    }
}
