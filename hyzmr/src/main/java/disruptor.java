import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ThreadFactory;

/**
 * @Description: disruptor
 * @author: mike
 * @date: 2020年09月25日 14:11
 */
public class disruptor
{
    public static void main(String[] args) throws Exception
    {


        // 生产者的线程工厂
        ThreadFactory threadFactory = new ThreadFactory(){
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "simpleThread");
            }
        };

        // RingBuffer生产工厂,初始化RingBuffer的时候使用
        EventFactory<Element> factory = new EventFactory<Element>() {
            @Override
            public Element newInstance() {
                return new Element();
            }
        };

        // 处理Event的handler
        EventHandler<Element> handler = new EventHandler<Element>(){
            @Override
            public void onEvent(Element element, long sequence, boolean endOfBatch)
            {
                System.out.println("---Element: " + element.get());
            }
        };

        // 阻塞策略
        BlockingWaitStrategy strategy = new BlockingWaitStrategy();

        // 指定RingBuffer的大小
        int bufferSize = 16;

        // 创建disruptor，生产者模式
        Disruptor<Element> disruptor = new Disruptor(factory, bufferSize, threadFactory, ProducerType.MULTI, strategy);

        // 设置EventHandler
        disruptor.handleEventsWith(handler);

        // 启动disruptor的线程
        disruptor.start();

        RingBuffer<Element> ringBuffer = disruptor.getRingBuffer();
        //测试自己写的多线程调用同一个ringbuffer。
       /* Thread t1=new Thread(new MikeTest(ringBuffer));
        Thread t2=new Thread(new MikeTest(ringBuffer));
        t1.start();
        t2.start();*/
        long cursor = disruptor.getCursor();


        for (int l = 0; l<17; l++)
        {
            // 获取下一个可用位置的下标
            long sequence = ringBuffer.next();
            try
            {
                // 返回可用位置的元素
                Element event = ringBuffer.get(sequence);
                // 设置该位置元素的值
                event.set(l);

            }
            finally
            {
                ringBuffer.publish(sequence);
            }
            Thread.sleep(10);
        }
    }
}
class MikeTest implements Runnable{
    private RingBuffer ringBuffer;
    public MikeTest(RingBuffer ringBuffer) {
        this.ringBuffer=ringBuffer;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int l = 0; l<10; l++)
        {
            // 获取下一个可用位置的下标
            long sequence = ringBuffer.next();
            try
            {
                // 返回可用位置的元素
                Element event = (Element) ringBuffer.get(sequence);
                // 设置该位置元素的值
                event.set(l);
            }
            finally
            {
                ringBuffer.publish(sequence);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// 队列中的元素
class Element {

    private int value;

    public int get(){
        return value;
    }

    public void set(int value){
        this.value= value;
    }

}
