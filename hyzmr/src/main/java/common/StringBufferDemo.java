package common;

/**
 * @Description: TODO
 * @author: mike
 * @date: 2020年12月17日 16:59
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        String str="main";
        change(str);
        StringBuffer s=new StringBuffer(str);
        System.out.println(str);
        change2(s);
        System.out.println(s);
        CharSequence cs="www.hl.com";
    }
    public static void change2(StringBuffer sb){
        sb.append("word");
    }
    public static void change(String temp){
        temp+="word";
    }
}
