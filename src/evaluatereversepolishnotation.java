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

˼· �������沨�����ʽ��ְ
���ȣ�����ǲ�������ô�ͽ����ջ���ǲ���������ô��ȡջ��������Ԫ�أ�ͨ����������������
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
