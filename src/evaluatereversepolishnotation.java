import java.util.Stack;

/**
 * Created by mengfanshan on 2017/7/16.
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
/*

思路 ：根据逆波兰表达式求职
首先，如果是操作数那么就进入堆栈，是操作符，那么就取栈顶的两个元素，通过操作符进行运算
 */
public class evaluatereversepolishnotation {
    public static void main(String[] args)
    {
        String[] var={"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(var));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/"))
            {
                int m2=stack.pop();
                int m1=stack.pop();
                if(tokens[i].equals("+"))
                {
                    stack.push(m1+m2);
                }
                else if(tokens[i].equals("-"))
                {
                    stack.push(m1-m2);
                }
                else if(tokens[i].equals("*"))
                {
                    stack.push(m1*m2);
                }
                else
                {
                    stack.push(m1/m2);
                }
            }
            else
            {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
