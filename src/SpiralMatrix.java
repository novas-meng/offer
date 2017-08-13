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

 ʹ��row_begin��ʾ�ϱ߽�
 ʹ�� row_end ��ʾ�±߽�
 ʹ�� col_begin ��ʾ��߽�
 ʹ�� col_end��ʾ�ұ߽�

 ������˳��Ӧ������-��-��-�� ���˳����б���

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
            //i==rows_begin ��ʾ�������� dire=0 �������� �� ��Ϊcols_end��ʱ����ô����Ҫ�������ߣ��ı䷽�� Ϊ2
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

            ����Ǵ���array={{3},{2}}�������
            ��Ϊ��������³�ʼֵΪrows_begin �� cols_end,�޷������������ߣ�
            ����ֱ���������߾Ϳ�����
             */
            else
            {
                i++;
            }
        }
        return list;
    }

}
