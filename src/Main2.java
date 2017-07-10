import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/19.
 */
public class Main2 {
    public static String getSeries(int length,String begin,String end)
    {
        int count=0;
        String series="";
        String[] app=new String[2];
        app[0]=begin;
        app[1]=end;
        for (int i=0;i<length;i++)
        {
            series=series+app[i%2];
        }
        return series;
    }
    public static int getDifferent(String l,String m)
    {
        char[] array1=l.toCharArray();
        char[] array2=m.toCharArray();
        int count=0;
        for (int i=0;i<array1.length;i++)
        {
            if(array1[i]!=array2[i])
            {
                count++;
            }
        }
        return count;
    }

    public static int getCount(String l)
    {
        int length=l.length();
        String series1=getSeries(length,"W","B");
        String series2=getSeries(length,"B","W");
        int count1=getDifferent(l,series1);
        int count2=getDifferent(l,series2);
        int mincount=Math.min(count1,count2);
        return mincount;
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        System.out.println(getCount(input));
    }
}
