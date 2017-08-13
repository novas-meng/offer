import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/8/12.
 */
public class Эјвз2 {
    public static int factors(int N){
        if(1 == N) return 1;
        int count = 2;
        final int sqrt_N = (int)Math.sqrt(N);
        int r;
        for(int i = 2; i <= sqrt_N; i++){
            if(0 == N % i){
                if(i == sqrt_N){
                    r = N / i;
                    if(r == i){
                        count++;
                    }else{
                        count += 2;
                    }
                }else{
                    count += 2;
                }
            }
        }

        return count;
    }
    public static int getMax(int n,int k)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=1;i<=k;i++)
        {
            int count=factors(i);
            count=i-count;
            //System.out.println("i="+i+","+count);
            count=count+k-i+1;
            map.put(i,count);
        }
        System.out.println(map);
        double[] array=new double[k+1];
        for (int i=0;i<=k;i++)
        {
            array[i]=1;
        }
        for (int i=1;i<n;i++)
        {
            for (int j=1;j<=k;j++)
            {
               array[j]=array[j]*map.get(j);
               System.out.println("i="+i+"j="+j+","+array[j]);
            }
        }
        double sum=0;
        for (int i=1;i<array.length;i++)
        {
            sum=(sum+array[i])%1000000007;
        }
        return (int)sum;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            System.out.println(getMax(n,k));
        }
    }
}
