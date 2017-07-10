import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/19.
 */
public class Main3 {
    public static int getCount(String input)
    {
        char[] chars=input.toCharArray();
        ArrayList<Character> list=new ArrayList<>();
        char last=' ';
        for (int i=0;i<chars.length;i++)
        {
            if(chars[i]!=last)
            {
                list.add(chars[i]);
                last=chars[i];
            }
        }
        return list.size();

    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        System.out.println(getCount(input));
    }
}
