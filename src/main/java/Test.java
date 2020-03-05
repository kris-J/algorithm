package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangjie
 * @Description: ${todo}
 * @date 2019/10/22 14:05
 */
public class Test {


    public static void main(String[] args) {

//        String str1 = new String("abc");//这个过程是运行时在堆内存中实时创建一个对象。
//        String str2 = new String("abc");//这个过程是运行时在堆内存中实时创建一个对象。
//        System.out.println(str1.equals(str2));//比较的是两个对象的值，是true
//        System.out.println(str1 == str2);//比较的是两个对象地址，是false

        Map<String,String> xx = new HashMap<>(1);
        xx.put("a","a");
        xx.put("b","b");

    }
}