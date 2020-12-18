package thread;

/**
 * @Description: TODO
 * @author: mike
 * @date: 2020年12月17日 15:23
 */
public class ThreadGuardian {
    public static void main(String[] args) {
        Thread userThread=new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"i="+i);
            }
        });
        Thread guardian=new Thread(()->{
            for (int i = 0; i <Integer.MAX_VALUE ; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"i="+i);
            }
        });
        guardian.setDaemon(true);
        userThread.start();
        guardian.start();
    }
}
