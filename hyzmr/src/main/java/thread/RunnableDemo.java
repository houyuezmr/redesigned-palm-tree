package thread;

/**
 * @Description: TODO
 * @author: mike
 * @date: 2020年11月27日 14:01
 */
public class RunnableDemo {
    public static void main(String[] args) {
        MyRunable mr=new MyRunable("123");
        new Thread(mr,"线程A").start();
        new Thread(mr).start();
        new Thread(mr,"线程B").start();
/*        for (int i=0;i<3;i++){
            String title="线程对象"+i;
            new Thread(()->{
                for (int j=0;j<10;j++){
                    System.out.println(title+"运行"+j);
                }
            }).start();

        }*/
    }
}
class MyRunable implements Runnable{

    private String title;
    public MyRunable(String title){
        this.title=title;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
