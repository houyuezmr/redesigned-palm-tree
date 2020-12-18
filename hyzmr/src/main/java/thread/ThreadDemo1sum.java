package thread;

/**
 * @Description: VolatileDemo
 * @author: mike
 * @date: 2020年12月17日 15:28
 */
public class ThreadDemo1sum {
    public static void main(String[] args) {
        Resource resource=new Resource();
        AddThread a=new AddThread(resource);
        SubThread b=new SubThread(resource);
        new Thread(a,"加法线程1").start();
        new Thread(a,"加法线程2").start();
        new Thread(b,"减法线程1").start();
        new Thread(b,"减法线程2").start();
    }
}
class Resource{
    private int num=0;

    private boolean flag=false;
    //flag =true  加法，false 减法

    public synchronized void add(){
        if(this.flag==false){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.num++;
        System.out.println("加法操作"+Thread.currentThread().getName()+"num="+this.num);
        this.flag=false;
        super.notifyAll();
    }
    public synchronized void sub(){
        if(this.flag==true){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.num--;
        System.out.println("减法操作"+Thread.currentThread().getName()+"num="+this.num);
        this.flag = true;
        super.notifyAll();
    }
}
class AddThread implements Runnable{
    private Resource resource;

    public AddThread(Resource resource) {
        this.resource = resource;
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
        for (int i = 0; i <50 ; i++) {
            this.resource.add();
        }
    }
}
class SubThread implements Runnable{
    private Resource resource;

    public SubThread(Resource resource) {
        this.resource = resource;
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
        for (int i = 0; i <50 ; i++) {
            this.resource.sub();
        }
    }
}
