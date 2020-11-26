package base;

/**
 * @Description: 代理模式练习
 * @author: mike
 * @date: 2020年11月23日 21:35
 */
public class ProxyTest {
    public static void main(String[] args) {
        IEat iEat=new EatProxy(new EatReal());
        iEat.get();
    }
}
interface IEat{
    public void get();
}
class EatReal implements IEat{

    @Override
    public void get() {
        System.out.println("得到一份食物吃");
    }
}
class EatProxy implements IEat{
    private IEat eat;

    public EatProxy(IEat eat){
        this.eat=eat;
    }
    public  void prepare(){
        System.out.println("买食材");
        System.out.println("处理食材");
    }
    public void clear(){
        System.out.println("清洁食材");
    }

    @Override
    public void get() {
        prepare();
        eat.get();
        clear();
    }
}
