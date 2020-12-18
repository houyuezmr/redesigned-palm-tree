package thread;

/**
 * @Description: TODO
 * @author: mike
 * @date: 2020年12月16日 16:42
 */
public class DadeLock implements  Runnable{

    private Jian j=new Jian();
    private XiaoQiang xq=new XiaoQiang();
    public DadeLock(){
        new Thread(this).start();
        xq.say(j);
    }

    public static void main(String[] args) {
        new DadeLock();
    }

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
        j.say(xq);
    }
}
class Jian{
    public synchronized void say (XiaoQiang xq){
        System.out.println("阿健说，小强给钱10块让过");
        xq.get();
    }
    public synchronized void get(){
        System.out.println("阿健说，过吧过吧");
    }
}
class XiaoQiang{
    public synchronized void say(Jian j){
        System.out.println("小强说，就不给钱");
        j.get();
    }
    public synchronized void get(){
        System.out.println("给钱了过吧");
    }
}
