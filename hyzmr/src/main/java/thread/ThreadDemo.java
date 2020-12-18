package thread;

/**
 * @Description: thread联系
 * @author: mike
 * @date: 2020年11月27日 11:35
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new MyThread("线程A").start();
        new MyThread("线程B").start();
        new MyThread("线程C").start();
    }
}
class MyThread extends Thread{
    private String title;
    public MyThread(String title){
        this.title=title;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(title+"-"+i);
        }
    }
}
