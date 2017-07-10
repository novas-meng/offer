import java.util.ArrayList;

/**
 * Created by mengfanshan on 2017/7/5.
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer> list=new ArrayList<>();
        for (int i=0;i<array.length;i++)
        {
            if(list.contains(array[i]))
            {
                list.remove(array[i]);
            }
            else
            {
                list.add(array[i]);
            }
        }
    }
}
