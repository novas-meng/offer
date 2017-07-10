import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class point{
    public double lon;
    public double lat;
    public point(double lon,double lat)
    {
        this.lat=lat;
        this.lon=lon;
    }
}
public class LocationUtils {

    private static double EARTH_RADIUS = 6378.137;

    public static double Distance(double long1, double lat1, double long2,
                                  double lat2) {
        double a, b, R;
        R = 6378137; // 地球半径
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        a = lat1 - lat2;
        b = (long1 - long2) * Math.PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2
                * R
                * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
                * Math.cos(lat2) * sb2 * sb2));
        return d;
    }
    private static double rad(double d) {    
        return d * Math.PI / 180.0;    
    }    
    
    /**   
     * 通过经纬度获取距离(单位：米)   
     * @param lat1   
     * @param lng1   
     * @param lat2   
     * @param lng2   
     * @return   
     */    
    public static double getDistance(double lat1, double lng1, double lat2,    
                                     double lng2) {    
        double radLat1 = rad(lat1);    
        double radLat2 = rad(lat2);    
        double a = radLat1 - radLat2;    
        double b = rad(lng1) - rad(lng2);    
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)    
                + Math.cos(radLat1) * Math.cos(radLat2)    
                * Math.pow(Math.sin(b / 2), 2)));    
        s = s * EARTH_RADIUS;    
        s = Math.round(s * 10000d) / 10000d;    
        s = s*1000;    
        return s;    
    }
    public static double[] MillierConvertion(double lon, double lat)
    {
        double L = 6378137 * Math.PI * 2;//地球周长
        double W=L;// 平面展开后，x轴等于周长
        double H=L/2;// y轴约等于周长一半
        double mill=2.3;// 米勒投影中的一个常数，范围大约在正负2.3之间
        double x = lon * Math.PI / 180;// 将经度从度数转换为弧度
        double y = lat * Math.PI / 180;// 将纬度从度数转换为弧度
        y=1.25 * Math.log( Math.tan( 0.25 * Math.PI + 0.4 * y ) );// 米勒投影的转换
        // 弧度转为实际距离
        x = ( W / 2 ) + ( W / (2 * Math.PI) ) * x;
        y = ( H / 2 ) - ( H / ( 2 * mill ) ) * y;
        double[] result=new double[2];
        result[0]=x;
        result[1]=y;
        return result;
    }
    public static void getArea(ArrayList<point> list)
    {
        point base=list.get(0);
        double sum=0;
        double[] base_array=MCT84Bl2xy(base.lon,base.lat);
        for (int i=1;i<list.size()-1;i++)
        {
            point A=list.get(i);
            point B=list.get(i+1);
            double[] a1=MCT84Bl2xy(A.lon,A.lat);
            double[] a2=MCT84Bl2xy(B.lon,B.lat);
            double ABASE_X=a1[0]-base_array[0];
            double ABASE_Y=a1[1]-base_array[1];
            double BBASE_X=a2[0]-base_array[0];
            double BBASE_Y=a2[1]-base_array[1];

            sum=sum+(ABASE_X*BBASE_Y-ABASE_Y*BBASE_X)*0.5;
        }
        System.out.println(sum);
    }
    public static ArrayList<point> readList()throws IOException
    {
        BufferedReader bufferedReader=new BufferedReader(new FileReader("temp.txt"));
        ArrayList<point> list=new ArrayList<>();
        String line=bufferedReader.readLine();
        while (line!=null)
        {
            String[] var=line.split(",");
            double lon=Double.valueOf(var[0]);
            double lat=Double.valueOf(var[1]);
            point point=new point(lon,lat);
            list.add(point);
            line=bufferedReader.readLine();
        }
        bufferedReader.close();
        return list;
    }
    public static void main(String[] args)throws IOException
    {
        double[] a1=BLToGauss(116.253014,39.917671);
        System.out.println(a1[0]+","+a1[1]);
        double[] a2=BLToGauss(116.252583,39.917831);
        System.out.println(Math.sqrt((a1[0]-a2[0])*(a1[0]-a2[0])+(a1[1]-a2[1])*(a1[1]-a2[1])));
        System.out.println(Distance(  116.253014,39.917671,116.252583,39.917831));
        ArrayList<point> list=readList();
        getArea(list);
    }


    public static double[] BLToGauss(double longitude, double latitude) {

        int ProjNo = 0;

        // 带宽
        int ZoneWide = 6;

        double longitude1, latitude1, longitude0, X0, Y0, xval, yval;
        double a, f, e2, ee, NN, T, C, A, M, iPI;

        // 3.1415926535898/180.0;
        iPI = 0.0174532925199433;

        // 54年北京坐标系参数
        a = 6378245.0;
        f = 1.0 / 298.3;

        // 80年西安坐标系参数
        // a=6378140.0;
        // f=1/298.257;

        ProjNo = (int) (longitude / ZoneWide);
        longitude0 = ProjNo * ZoneWide + ZoneWide / 2;
        longitude0 = longitude0 * iPI;

        // 经度转换为弧度
        longitude1 = longitude * iPI;

        // 纬度转换为弧度
        latitude1 = latitude * iPI;

        e2 = 2 * f - f * f;
        ee = e2 * (1.0 - e2);
        NN = a / Math.sqrt(1.0 - e2 * Math.sin(latitude1) * Math.sin(latitude1));
        T = Math.tan(latitude1) * Math.tan(latitude1);
        C = ee * Math.cos(latitude1) * Math.cos(latitude1);
        A = (longitude1 - longitude0) * Math.cos(latitude1);
        M = a * ((1 - e2 / 4 - 3 * e2 * e2 / 64 - 5 * e2 * e2 * e2 / 256) * latitude1 - (3 * e2 / 8 + 3 * e2 * e2 / 32 + 45 * e2 * e2 * e2 / 1024) * Math.sin(2 * latitude1) + (15 * e2 * e2 / 256 + 45 * e2 * e2 * e2 / 1024) * Math.sin(4 * latitude1) - (35 * e2 * e2 * e2 / 3072) * Math.sin(6 * latitude1));
        xval = NN * (A + (1 - T + C) * A * A * A / 6 + (5 - 18 * T + T * T + 72 * C - 58 * ee) * A * A * A * A * A / 120);
        yval = M + NN * Math.tan(latitude1) * (A * A / 2 + (5 - T + 9 * C + 4 * C * C) * A * A * A * A / 24 + (61 - 58 * T + T * T + 600 * C - 330 * ee) * A * A * A * A * A * A / 720);
        X0 = 1000000L * (ProjNo + 1) + 500000L;
        Y0 = 0;
        xval = xval + X0;
        yval = yval + Y0;
        return new double[] { xval, yval };
    }



    public static double[] MCT84Bl2xy(double l, double B)
    {
            double[] res=new double[2];
            l = l * Math.PI /180;
            B = B * Math.PI /180;
            double B0 =30* Math.PI /180;
            double N =0, e =0, a =0, b =0, e2 =0, K =0;
            a =6378137;
            b =6356752.3142;
            e = Math.sqrt(1- (b / a) * (b / a));
            e2 = Math.sqrt((a / b) * (a / b) -1);
            double CosB0 = Math.cos(B0);
            N = (a * a / b) / Math.sqrt(1+ e2 * e2 * CosB0 * CosB0);
            K = N * CosB0;
            double Pi = Math.PI;
            double SinB = Math.sin(B);
            double tan = Math.tan(Pi /4+ B /2);
            double E2 = Math.pow((1- e * SinB) / (1+ e * SinB), e /2);
            double xx = tan * E2;
            double xc = K * Math.log(xx);
            double yc = K * l;
            res[0]=xc;
            res[1]=yc;
            return res;
    }

}