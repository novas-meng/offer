import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/26.
 */
public class Main8 {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] array=new int[n+1];
        for (int i=1;i<=n;i++)
        {
            int temp=0;
            for (int j=i;j>0;j--)
            {
                temp=temp+array[j-1];
            }
            array[i]=temp+1;
        }
        System.out.println(array[n]);
    }
}
