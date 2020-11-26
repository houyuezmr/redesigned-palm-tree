package base;

/**
 * @Description: TODO
 * @author: mike
 * @date: 2020年11月20日 16:06
 */
public class Templete {
    public static void main(String[] args) {
        int i=1;
        Integer i2=1;
        Action robotAction= new Robot();
        Action personAction= new Person();
        Action pigAction= new Pig();
        robotAction.command(Action.SLEEP);
        robotAction.command(Action.WORK);
        personAction.command(Action.SLEEP+Action.WORK+Action.EAT);
        pigAction.command(Action.SLEEP);
        pigAction.command(Action.WORK);
    }
}
abstract  class  Action{
    public  static final int EAT = 1;
    public  static final int SLEEP = 5;
    public  static final int WORK = 10;
    public void command(int code){
        switch (code){
            case EAT:{
                this.eat();
                break;
            }
            case SLEEP:{
                this.sleep();
                break;
            }
            case WORK:{
                this.work();
                break;
            }
            case EAT+SLEEP+WORK:{
                this.eat();
                this.sleep();
                this.work();
                break;
            }
        }
    }
    public abstract void eat();
    public abstract void sleep();
    public abstract void work();
}
class Robot extends Action{

    @Override
    public void eat() {
        System.out.println("机器人充电");
    }

    @Override
    public void sleep() {

    }

    @Override
    public void work() {
        System.out.println("机器人按照固定套路工作");
    }
}
class Person extends Action{

    @Override
    public void eat() {
        System.out.println("坐下来吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("做春梦");
    }

    @Override
    public void work() {
        System.out.println("有想法的工作");
    }
}
class Pig extends Action{

    @Override
    public void eat() {
        System.out.println("吃剩饭");
    }

    @Override
    public void sleep() {
        System.out.println("倒地就睡");
    }

    @Override
    public void work() {
        System.out.println("不工作");
    }
}
