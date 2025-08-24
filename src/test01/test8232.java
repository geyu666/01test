/*重载练习比较大小：

题目描述：

利用函数重载完成三个比较大小的Compare函数，供主函数调用

三个Compare函数分别可以处理两个整数、两个字符、两个字符串的比较。

若两个整数比较：若第一个值大于第二个值，则输出最大的一个

若两个字符比较：输出他们的ASC码差值的绝对值

若两个字符串比较：输出最大的一个字符串



要求这三个函数都叫做Compare函数，利用参数类型不同，用函数重载实现

输入格式：

三行

第一行，两个整数，空格分开

第二行，两个字符，空格分开

第三行，两个字符串，空格分开

输出格式：

三行

        第一行最大的一个数

第二行两个字符ASC码差值的绝对值

        第三行最大的一个字符串

样例输入：

        10 20
A a
Dotcpp com

样例输出：

        20
        32
com

来源：https://www.dotcpp.com/oj/problem2008.html
难度：中等*/
package test01;

import java.util.Scanner;

public class test8232 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        char char1 = sc.next().charAt(0);
        char char2 = sc.next().charAt(0);

        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(Compare(a, b));
        System.out.println(Compare(char1, char2));
        System.out.println(Compare(str1, str2));
    }

    public static int Compare(int a, int b) {
        return Math.max(a, b);
    }

    public static int Compare(char a, char b) {
        return Math.abs((int) a - (int) b);
    }

    //首个字母的字典序比较
    public static String Compare(String a, String b){
        return (a.compareTo(b)> 0? a : b);
    }
}
