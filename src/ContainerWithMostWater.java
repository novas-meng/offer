/**
 * Created by mengfanshan on 2017/8/8.
 */
public class ContainerWithMostWater {

    public static void main(String[] args)
    {
        int[] array={2,1};
        System.out.println(maxArea(array));
    }
    public static int maxArea(int[] height) {

        /*
          �����ⷨ����ʱ
        int max=0;
        for (int i=0;i<height.length;i++)
        {
            for (int j=i+1;j<height.length;j++)
            {
                int now=Math.min(height[j],height[i])*(j-i);
                if(now>max)
                {
                    max=now;
                }
            }
        }
        return max;
         */
        /*
         ʹ����βָ����������ͷָ����ڽ�βָ��ʱ���ƶ���βָ��

         Ϊʲô��ô�����������ƶ�ָ���ʱ����Ҫ��ֹһ��������������ǰ�ͷָ���i�ƶ���i+1
         βָ����j�����ʱ�����ǵ�����Ϊi+1,j �������i i+1������������Ž⣬��ô����ʹ���
         ���Ե�ͷָ�����βָ���ʱ������ƶ�ͷָ�룬��ô�Ϳ��ܳ��� i i+1 ����Ϊ���Ž⣬
         ���� i=1 i+1=2 array[i]=100 array[i+1]=100  j=10 array[j]=1
         ��ôi i+1 ��������ֵΪ100 ��Զ���� ��ǰ���ֵ(10-1)*1=9,��������ƶ�ͷָ�룬��������ͻᱻ©��
         ��������ƶ�βָ�룬��j �ƶ���j-1 λ�ã�j-1 j ��ֵ�����ֵΪ min(array[j],array[j-1])
         С�ڵ�ǰ����Сֵ�ģ���Ϊarray[i]> array[j] �����ƶ�βָ�벻Ӱ��

         */
        int begin=0;
        int end=height.length-1;
        int max=0;
        while (begin<end)
        {
            max=Math.max(max,Math.min(height[begin],height[end])*(end-begin));
            if(height[begin]>height[end])
            {
                end--;
            }
            else
            {
                begin++;
            }
        }
        return max;
    }
}
