//大小写转换
//        设计一个程序, 输入一行字符串, 将其中大写转为小写, 小写转为大写. 其余字符不变
//        (字符串长度<100)
//        样例输入: hELLO wORLD!
//        样例输出: Hello World!
//
//        来源：日常练习题-字符/字符串-第1题
//        难度：简单
package test01;
import java.util.*;

public class test7261 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder ss = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(Character.isUpperCase(s.charAt(i))){
                ss.append(Character.toLowerCase(s.charAt(i)));
            }
            else{
                ss.append(Character.toUpperCase(s.charAt(i)));
            }
        }
        System.out.println(ss);
    }
}
