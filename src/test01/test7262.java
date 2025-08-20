//开挂很危险
//最近网络盗号严重, 张三又喜欢开外挂(大家不要学)
//于是张三打算出一个安全的密码, 避免开外挂后被盗号
//        请各位小伙伴帮忙, 判定一下张三的密码是否安全
//安全密码的判定:
//        1. 长度在8~16之间
//2. 开头必须是大写
//3* 密码最少包含一个小写字母, 一个数字, 一个特殊符号
//特殊符号包括~!@#$%*
//设计一个程序 输入密码字符串
//如果密码安全, 打印true, 否则打印false
//        (字符串长度<100)
//样例输入:
//Aa123!!!!!
//样例输出:
//        true
//
//来源：日常练习题-字符/字符串-第2题
//难度：简单
//1.输入
//2.判断
//3.输出
package test01;
import java.util.*;

public class test7262 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String sp = "~!@#$%*";
        boolean bool = true;
        boolean Lowerbool = false;
        boolean Digitbool = false;
        boolean Specialbool = false;
        if(s.length() < 8 || s.length() > 16 )
        {
            bool = false;
        }
        for(int i = 0;i < s.length();i++)
        {
            if(!Character.isUpperCase(s.charAt(0)))
            {
                bool = false;
            }
            if(Character.isLowerCase(s.charAt(i))){
                Lowerbool = true;
            }
            else if(Character.isDigit(s.charAt(i))){
                Digitbool = true;
            }
            else if(sp.indexOf(s.charAt(i)) >= 0){
                Specialbool = true;
            }
        }
        if(Lowerbool && Digitbool && Specialbool){
            bool = true;
        }
        System.out.println(bool);
    }
}
