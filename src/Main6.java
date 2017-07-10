import java.util.Scanner;
import java.util.Spliterators;

/**
 * Created by mengfanshan on 2017/6/21.
 */
public class Main6 {
    public static void getCount(String input)
    {
        char[] chars=input.toCharArray();
        for (int i=0;i<chars.length;i++)
        {
            if(chars[i]=='?')
            {
                if(i==0)
                {
                    if(chars[i+1]=='A')
                    {
                        chars[i]='B';
                    }
                    else if(chars[i+1]=='?')
                    {
                        chars[i]='C';
                        chars[i+1]='C';
                    }
                    else
                    {
                        chars[i]='A';
                    }
                }
                else if(i==chars.length-1)
                {
                    if(chars[i-1]=='C')
                    {
                        chars[i]='C';
                    }
                    else if(chars[i-1]=='A')
                    {
                        chars[i]='B';
                    }
                    else
                    {
                        chars[i]='A';
                    }
                }
                else
                {
                    if(chars[i-1]=='A')
                    {
                        chars[i]='B';
                    }
                    else if(chars[i-1]=='C')
                    {
                        chars[i]='C';
                    }
                    else
                    {
                        chars[i]='A';
                    }
                }
            }
        }
        System.out.println(new String(chars));
        int count=0;
        for (int i=0;i<chars.length-1;i++)
        {
            if(chars[i]=='C')
            {
                continue;
            }
            if(chars[i+1]==chars[i])
            {
                count++;
            }
        }
        System.out.println(count);

    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        getCount(input);
    }
}
