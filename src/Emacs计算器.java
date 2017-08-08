import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mengfanshan on 2017/7/20.
 * Emacs号称神的编辑器，它自带了一个计算器。与其他计算器不同，它是基于后缀表达式的，即运算符在操作数的后面。例如“2 3 +”等价于中缀表达式的“2 + 3”。
 请你实现一个后缀表达式的计算器。
 输入描述:
 输入包含多组数据。

 每组数据包括两行：第一行是一个正整数n (3≤n≤50)；紧接着第二行包含n个由数值和运算符组成的列表。

 +-* 分别为加减乘除四则运算，其中除法为整除，即“5/3=1”。
        输出描述:
        对应每一组数据，输出它们的运算结果。
        示例1
        输入

        3
        2 3 +
        5
        2 2 + 3 *
        5
        2 2 3 + *
        输出

        5
        12
        10
 */

public class Emacs计算器 {
    public static int nibolan(String line)
    {
        String[] array=line.split(" ");
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<array.length;i++)
        {
            if(array[i].equals("+"))
            {
                int m2=stack.pop();
                int m1=stack.pop();
                stack.push(m2+m1);
            }
            else if(array[i].equals("-"))
            {
                int m2=stack.pop();
                int m1=stack.pop();
                stack.push(m1-m2);
            }
            else if(array[i].equals("*"))
            {
                int m2=stack.pop();
                int m1=stack.pop();
                stack.push(m2*m1);
            }
            else if(array[i].equals("/"))
            {
                int m2=stack.pop();
                int m1=stack.pop();
                stack.push(m1/m2);
            }
            else
            {
                stack.push(Integer.valueOf(array[i]));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int m=scanner.nextInt();
            scanner.nextLine();
            String line=scanner.nextLine();
            System.out.println(nibolan(line));
        }
    }

}
