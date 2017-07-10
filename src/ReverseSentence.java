/**
 * Created by mengfanshan on 2017/7/6.
 */
public class ReverseSentence {
    public static void main(String[] args)
    {
        String str="student. a am I";
        System.out.println(ReverseSentence(str));
    }
    public static String ReverseSentence(String str) {
        if(str.equals("")||str==null)
        {
            return "";
        }
        String[] var=str.split(" ");
        int i=0;
        int j=var.length-1;
        while (i<j)
        {
            String temp=var[i];
            var[i]=var[j];
            var[j]=temp;
            i++;
            j--;
        }
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(var[0]);
        for(int k=1;k<var.length;k++)
        {
            stringBuilder.append(" "+var[k]);
        }
        return stringBuilder.toString();
    }
}
