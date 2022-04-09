package value;

import org.junit.Test;

/**
 * program javaSe
 * <p>
 * description 字符串
 *
 * @author wuqia
 * @date 2022-04-04 20:50
 **/
public class StringTest {

    @Test
    public void StringTest() {
        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false
    }

    @Test
    public void StringTest1() {
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        System.out.println(aa==bb);// true
    }

    @Test
    public void StringTest2() {
        // 字符串使用 final 关键字声明之后，可以让编译器当做常量来处理。
        final String str1 = "str";
        final String str2 = "ing";
        // 下面两个表达式其实是等价的
        String c = "str" + "ing";// 常量池中的对象
        String d = str1 + str2; // 常量池中的对象
        System.out.println(c == d);// true
    }

    @Test
    public void StringTest3() {
        // 示例代码如下（str2 在运行时才能确定其值）：
        final String str1 = "str";
        final String str2 = getStr();
        String c = "str" + "ing";// 常量池中的对象
        String d = str1 + str2; // 在堆上创建的新的对象
        System.out.println(c == d);// false
    }

    @Test
    public void StringTest4() {
        String str1 = "abcd";
        String str2 = new String("abcd");
        String str3 = new String("abcd");
        System.out.println(str1==str2);
        System.out.println(str2==str3);
    }

    public static String getStr() {
        return "ing";
    }
}
