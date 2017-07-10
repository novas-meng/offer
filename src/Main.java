import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/19.
 */
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int length=scanner.nextInt();
        int[] prices=new int[1001];
        int index=3;
        for (int i=0;i<length;i++)
        {
            prices[scanner.nextInt()]=1;
        }
        int thirdprice=-1;
        for (int i=0;i<prices.length;i++)
        {
            if(prices[i]!=0)
            {
                if(index!=1)
                {
                    index--;
                }
                else
                {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(thirdprice);
    }
}
