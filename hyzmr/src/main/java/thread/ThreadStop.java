package thread;

/**
 * @Description: 线程停止
 * @author: mike
 * @date: 2020年12月17日 15:08
 */
public class ThreadStop {
    public static boolean flag=true;
    public static void main(String[] args) {
        new Thread(()->{
            long num=0;
            while (flag){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"num="+num++);
            }
        },"执行线程").start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag=false;
    }
}
