//张三上课时走神, 在作业上写了很多222222222222222 结果被老师发现了
//        张三连忙掩饰说自己在算2+22+222+2222+22222的和,
//        老师很欣慰, 问他算出来没有
//        张三很困扰, 因为草稿纸写满了2 已经不够用了
//        大家快帮帮张三吧
//        设计一个程序, 输入n和a 求Sn
//        Sn = a + aa + aaa + … + aaaaa(n个a)
//        输入: 两个整数n, a
//        (1<n<9), (1<=a<=9)
//        输出:
//        Sn的值
//        样例输入:
//        5 2
//        样例输出:
//        24690
//        样例解析: Sn = 2 + 22 + 222 + 2222 + 22222 = 24690
//        样例输入:
//        4 5
//        样例输出:
//        6170
//        样例解析: Sn = 5 + 55 + 555 + 5555
//
//        来源：每日练习题-简单循环-第2题
//        难度：简单
//        1.输入n和a
//        2.计算Sn
//        （1）循环n次
//        （2）每次高位多一个a
//        （3）求和
//        3.输出Sn
package test01;
import java.util.Scanner;

public class test7222 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int num = 0;
        int Sn = 0;
        for (int i = 1; i <= n; i++) {
            num = num + a * (int)Math.pow(10,i-1);
            Sn += num;
        }
        System.out.println("Sn = " + Sn);
    }
}
