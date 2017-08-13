import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengfanshan on 2017/8/13.
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].

 使用row_begin表示上边界
 使用 row_end 表示下边界
 使用 col_begin 表示左边界
 使用 col_end表示右边界

 遍历的顺序应该是右-下-左-上 这个顺序进行遍历

 */
public class SpiralMatrix {
    public static void main(String[] args)
    {
        //int[][] array={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
      //  int[][] array={{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
        int[][] array={{3,2}};
        System.out.println(spiralOrder(array));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix==null||matrix.length==0)
        {
            return list;
        }
        int rows=matrix.length;
        int cols=matrix[0].length;
        int i=0;
        int j=0;
        int cols_begin=0;
        int cols_end=cols-1;
        int rows_begin=0;
        int rows_end=rows-1;
        int dire=0;
        while (list.size()!=rows*cols)
        {
            list.add(matrix[i][j]);
            //i==rows_begin 表示向右行走 dire=0 表明方向 当 列为cols_end的时候，那么就需要向下行走，改变方向 为2
            if(i==rows_begin&&j<cols_end&&dire==0)
            {
                j++;
                if(j==cols_end)
                {
                    rows_begin=rows_begin+1;
                    dire=1;
                }
            }
            else if(j==cols_end&&i<rows_end&&dire==1)
            {
                i++;
                if(i==rows_end)
                {
                    cols_end=cols_end-1;
                    dire=2;
                }
            }
            else if(i==rows_end&&j>cols_begin&&dire==2)
            {
                j--;
                if(j==cols_begin)
                {
                    rows_end=rows_end-1;
                    dire=3;
                }
            }
            else if(j==cols_begin&&i>rows_begin&&dire==3)
            {
                i--;
                if(i==rows_begin)
                {
                    cols_begin=cols_begin+1;
                    dire=0;
                }
            }
            /*

            这个是处理array={{3},{2}}这种情况
            因为这种情况下初始值为rows_begin 和 cols_end,无法进行向右行走，
            所以直接向下行走就可以了
             */
            else
            {
                i++;
            }
        }
        return list;
    }

}
