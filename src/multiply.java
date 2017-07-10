/**
 * Created by mengfanshan on 2017/7/7.
 * 给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 */
public class multiply {

    public static void main(String[] args)
    {
        int[] array={1,2,3,4,5,6,7};
        multiply(array);
    }

    public static int[] multiply(int[] A) {
        int[] B=new int[A.length];
        int[] C=new int[A.length];
        C[B.length-1]=1;
        B[0]=1;
        for (int i=1;i<B.length;i++)
        {
            B[i]=A[i-1]*B[i-1];
        }
        for (int i=B.length-2;i>=0;i--)
        {
            C[i]=C[i+1]*A[i+1];
        }
        for (int i=0;i<B.length;i++)
        {
            B[i]=B[i]*C[i];
        }
        return B;
    }
}
