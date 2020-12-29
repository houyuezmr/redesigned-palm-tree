package base;

/**
 * @Description: TODO
 * @author: mike
 * @date: 2020年11月23日 20:59
 */
public class Factorytest {
    public static void main(String[] args) {
        IFood iFood=Factory.getInstance("milk");
        iFood.eat();
        
    }

}
interface IFood{
    public void eat();
}
class Bread implements IFood{

    @Override
    public void eat() {
        System.out.println("吃面包");
    }
}
class MilK implements IFood{

    @Override
    public void eat() {
        System.out.println("喝牛奶");
    }
}
class Factory{
    public static IFood getInstance(String className){
        if("bread".equals(className)){
            return new Bread();
        }else if ("milk".equals(className)){
            return new MilK();
        }else {
            return null;
        }
    }
}
