package base;

/**
 * @Description: TODO
 * @author: mike
 * @date: 2020年10月28日 16:30
 */
public class Shared {
    public static void main(String[] args) {
        String s1="shared";
        String s2="shared";
        System.out.println(s1==s2);
        System.out.println(s1.getBytes());
        System.out.println(s2.getBytes());
        String sA=new String("123");
        String sB=new String("123");
        System.out.println(sA==sB);
        System.out.println(sA.getBytes());
        System.out.println(sB.getBytes());
        int a=sB.indexOf("23");
        System.out.println(a);
        System.out.println(args);
    }
}
