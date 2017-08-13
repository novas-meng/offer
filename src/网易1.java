import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/8/12.
 */
public class Эјвз1 {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            long x=scanner.nextLong();
            long f=scanner.nextLong();
            long d=scanner.nextLong();
            long p=scanner.nextLong();
            double x1=x;
            double f1=f;
            double d1=d;
            double p1=p;
            int day=(int)((d1+p1*f1)/(x1+p1));
            int min=(int)(d1/x1);
            System.out.println(Math.min(day,min));
        }
    }
}
