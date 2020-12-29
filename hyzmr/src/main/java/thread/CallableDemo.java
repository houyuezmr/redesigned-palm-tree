package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description: Callable练习
 * @author: mike
 * @date: 2020年11月27日 16:43
 */
public class CallableDemo {
    public static void main(String[] args) {
        FutureTask<String> task=new FutureTask<String>(new MyCallable());
        new Thread(task).start();
        System.out.println("线程返回数据");
    }
}
class MyCallable implements Callable {

    @Override
    public String call() throws Exception {

        for (int i=0;i<10;i++){
            System.out.println("线程执行"+i);
        }

        return "线程执行完毕";
    }
}
