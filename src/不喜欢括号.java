import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mengfanshan on 2017/7/21.
 * NowCoder从小就喜欢数学，喜欢在笔记里记录很多表达式。它觉得现在的表达式写法很麻烦，为了提高运算符优先级，不得不添加很多括号，不小心漏了一个右括号的话差之毫厘谬之千里。
 因此他改用前缀表达式，例如`(2 + 3) * 4`写成`* + 2 3 4`，这样就能避免使用括号了。这样的表达式书写简单，但计算却不够直观。请你写一个程序帮他计算这些前缀表达式吧。
 输入描述:
 输入包含多组数据，每组数据包含两行。

 第一行为正整数n（3≤n≤50），紧接着第二行包含n个由数值和运算符组成的列表。

 +-* /
分别为加减乘除四则运算，其中除法为整除，即5/3=1。
        输出描述:
        对应每一组数据，输出它们的运算结果。
        示例1
        输入

        3
        + 2 3
        5
        * + 2 2 3
        5
        * 2 + 2 3
        输出

        5
        12
        10
 */
public class 不喜欢括号 {
    public static int qianzhui(String[] datas)
    {
        Stack<Integer> queue=new Stack<>();
        for (int i=datas.length-1;i>=0;i--)
        {
            if(datas[i].equals("/"))
            {
                int m1=queue.pop();
                int m2=queue.pop();
                queue.add(m1/m2);
            }
            else if(datas[i].equals("*"))
            {
                int m1=queue.pop();
                int m2=queue.pop();
                queue.add(m1*m2);
            }
            else if(datas[i].equals("+"))
            {
                int m1=queue.pop();
                int m2=queue.pop();
                queue.add(m1+m2);
            }
            else if(datas[i].equals("-"))
            {
                int m1=queue.pop();
                int m2=queue.pop();
                queue.add(m1-m2);
            }
            else
            {
                queue.push(Integer.valueOf(datas[i]));
            }
        }
        return queue.pop();
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int m=scanner.nextInt();
            scanner.nextLine();
            String line=scanner.nextLine();
            String[] datas=line.split(" ");
            System.out.println(qianzhui(datas));
        }
    }
}
