package base;

/**
 * @Description: TODO
 * @author: mike
 * @date: 2020年11月23日 20:59
 */
public class FactoryGenerictest {
    public static void main(String[] args) {
        IMessage1 mes=Factory1.getInstance("messageImpl");
        IMessage2 mes2=Factory1.getInstance("messageImpl2");
        mes.send("123");
        mes2.send("123");
    }
}

interface IMessage1{
    public void send(String str);
}

class MessageImpl implements IMessage1{

    @Override
    public void send(String str) {
        System.out.println(str);
    }
}
interface IMessage2{
    public void send(String str);
}

class MessageImpl2 implements IMessage2{

    @Override
    public void send(String str) {
        System.out.println(str);
    }
}

class Factory1{
    public static <T> T getInstance(String className){
        if("messageImpl".equals(className)){
            return (T) new MessageImpl();
        }else if("messageImpl2".equals(className)){
            return (T) new MessageImpl2();
        }else {
            return null;
        }
    }
}
