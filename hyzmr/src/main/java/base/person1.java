package base;

/**
 * @Description: TODO
 * @author: mike
 * @date: 2020年10月26日 22:02
 */
public class person1 {
    public static void main(String[] args) {
        Person2 p=null;
        p=new Person2();
        p.setAge(1);
        System.out.println(p.getAge());
        String s="nmdx";
        System.out.println("nmdx".equals(s));
    }
    private void canChange(int ... data){
    }
}
