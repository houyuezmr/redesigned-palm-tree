package base;

enum Color implements  IMessage2{
    RED("red"){
        public  String getMessage2(){
            return  this.toString();
        }
    },GREEN("green"){
        public  String getMessage2(){
            return  this.toString();
        }
    },YELLOW("yellow"){
        public  String getMessage2(){
            return  this.toString();
        }
    };
    private String title;
    private Color(String title){
        this.title =title;
    }
    public String toString(){
        return this.title;
    }
    public abstract String getMessage2();
    @Override
    public void send(String str) {
        System.out.println(str);
    }
}

/**
 * @Description: 枚举测试
 * @author: mike
 * @date: 2020年11月26日 14:16
 */
public class EnumDemo {
    public static void main(String[] args) {
        Color c=Color.GREEN;
        for (Color temp:
             Color.values()) {
            System.out.println(temp.name()+"--"+temp.ordinal());
        }
        c.send("123");

        c.getMessage2();
    }
}
