import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/28.
 */
public class Main11 {
    //返回一个大小为n的数组，如果array[i]=0 表示i是质数
    public static int[] getOdd(int n)
    {
        int[] array=new int[n+1];
        array[0]=1;
        array[1]=1;
        for (int i=2;i<=n;i++)
        {
            for (int j=i+1;j<=n;j++)
            {
                if(j%i==0)
                {
                    array[j]=1;
                }
            }
        }
        return array;
    }
    public static int getCount(int[] array,int n)
    {
        int count=0;
        for (int i=2;i<=n/2;i++)
        {
            int j=n-i;
            if(array[i]==0&&array[j]==0)
            {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] array=getOdd(n);
        getCount(array,n);
    }
}
