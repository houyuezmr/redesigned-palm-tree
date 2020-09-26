/**
 * @Description: Cache line
 * @author: mike
 * @date: 2020年09月25日 20:25
 */
public class cacheline {
    //CPU每次从主存中拉取数据时，会把相邻的数据也存入同一个cache line。
    //
    //在访问一个long数组的时候，如果数组中的一个值被加载到缓存中，它会自动加载另外7个。
    static long[][] arr;
    public static void main(String[] args) {

        arr=new long[1024*1024][];
        for (int i=0;i<1024*1024;i++){
            arr[i]=new long[8];
            for (int j = 0; j <8 ; j++) {
                arr[i][j]=0L;
            }
        }
        long sum=0;
        long marked=System.currentTimeMillis();
        for (int i = 0; i < 1024 * 1024; i+=1) {
            for(int j =0; j< 8;j++){
                sum = arr[i][j];
            }
        }
        System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");

        marked = System.currentTimeMillis();
        for (int i = 0; i < 8; i+=1) {
            for(int j =0; j< 1024 * 1024;j++){
                sum = arr[j][i];
            }
        }
        System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");

    }

}
