//求平均年龄
//        01星球有学长若干名, 给出每个学长的年龄, 求01星球学长的平均年龄, 保留小数点后两位
//        输入:
//        第一行: 整数n(1<n<100), 表示人数
//        之后n行: 每行一个整数a(15<a<55), 表示第n个学长的年龄
//        输出:
//        一个浮点数, 保留两位小数. 表示01星球学长平均年龄
//        样例输入:
//        3
//        18
//        18
//        17
//        样例输出:
//        17.67
//
//        来源：每日练习题-简单循环-第1题
//        难度：简单
//        1.输入整数n
//        2.循环输入整数a
//        3.计算平均浮点数
//        4.输出结果
package test01;
import java.util.Scanner;

public class test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        double num = 0;
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            num += a;
        }
        num = num / n;
        System.out.printf("%.2f",num);
    }
}
