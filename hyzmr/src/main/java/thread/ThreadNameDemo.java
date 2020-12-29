package thread;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

/**
 * @Description: TODO
 * @author: mike
 * @date: 2020年12月07日 11:17
 */
public class ThreadNameDemo {
    public static void main(String[] args) throws Exception{
        ThreadName tn=new ThreadName();
        new Thread(tn,"线程A").start();
        new Thread(tn).start();
        new Thread(tn,"线程B").start();
        tn.run();
        new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        },"线程对象").start();
        Thread.interrupted();
        Thread mythread=Thread.currentThread();
        Runnable run1=new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    System.out.println("run");
                }
            }
        };
        Thread threadA=new Thread(run1);
        new Thread(run1).start();
        threadA.start();
        mythread.setPriority(5);
        System.out.println(threadA.getPriority());
    }
}
class ThreadName implements Runnable{

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
