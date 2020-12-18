package common;

import java.io.Closeable;

interface IMessage{
    public void send();
}

/**
 * @Description: AutoCloseable自动关闭
 * @author: mike
 * @date: 2020年12月17日 18:13
 */
public class AutoCloseableDemo {
    public static void main(String[] args) {
       /* MyMessage nm=new MyMessage("www");
        if(nm.open()){
            nm.send();

        }*/
       try (MyMessage nm=new MyMessage("www")){
           if(nm.open()){
               nm.send();
           }
       }catch (Exception e){

       }
    }
}

class MyMessage implements  IMessage,AutoCloseable{
    private String msg;

    public MyMessage(String msg) {
        this.msg = msg;
    }

    public boolean open(){
        System.out.println("获取消息发送连接资源");
        return  true;
    }


    @Override
    public void send() {
        System.out.println("发送消息"+this.msg);
    }

    @Override
    public void close() throws Exception {
            System.out.println("消息通道关闭");
    }
}
