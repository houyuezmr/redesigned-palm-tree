package base;

import java.awt.*;

/**
 * @Description: 泛型练习
 * @author: mike
 * @date: 2020年11月25日 15:59
 */
public class GenericTest {
    public static void main(String[] args) {
        Point<Integer> p1=new Point<Integer>();
        p1.setX(11);
        p1.setY(11);
        System.out.println(p1.getX()+"__"+p1.getY());
        say(p1);
        Integer[] fun1=fun(1,2,3);
        for (int temp :
             fun1) {
            System.out.println(temp);
        }
    }
    public static <T> T[] fun (T ... args){
        return  args;
    }
    public static void say(Point<?> say1){
        System.out.println(say1.getX());
    }

}
class Point<T> {
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}
