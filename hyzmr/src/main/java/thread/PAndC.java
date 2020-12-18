package thread;

/**
 * @Description: PAndC
 * @author: mike
 * @date: 2020年12月17日 14:16
 */
public class PAndC {
    public static void main(String[] args) {
        Message msg=new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();

    }
}
class Producer implements  Runnable{
    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
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
        /*for (int i = 0; i <100 ; i++) {
            if((i % 2)== 0){
                this.msg.setTitle("王建");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.msg.setContent("宇宙大帅哥");
            }else {
                this.msg.setTitle("小高");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.msg.setContent("猥琐第一人");
            }
        }*/
        for (int i = 0; i <100 ; i++) {
            if((i % 2)== 0){
                this.msg.set("王建","宇宙大帅哥");

            }else {
                this.msg.set("小高","猥琐第一人");
            }
        }

    }
}
class  Consumer implements Runnable{
    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
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
       /* for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.msg.getTitle()+"-"+this.msg.getContent());
        }*/
        for (int i = 0; i < 100; i++) {
            System.out.println(this.msg.get());
        }
    }
}
class Message{
    private String title;
    private String content;
    private boolean flag=true;
    public synchronized void set(String title, String content){
        if(!this.flag){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title=title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.content=content;
        this.flag=false;
        super.notify();
    }

    public synchronized String get(){
        if(flag){
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
        try{
            return this.title+"-"+this.content;
        }finally {
            this.flag=true;
            super.notify();
        }
    }
 /*   public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }*/
}
