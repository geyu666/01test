/*题目描述：
学习完带类的C++/Java课程，下面来设计一个时间类Time，要求Time里面有h、m、s三个私有成员代表时分秒

以及两个成员函数，第一个成员函数叫Set,有一个整形形参，代表秒数，根据这个形参转化成对应的时间。

第二个成员函数，是Display可以输出时间，以H:M:S的格式



要求在主函数中定义Time类，首先调用Set函数将秒数传入，然后调用Display函数输出时间

输入格式：

输入一个秒数t，整形（0< =t< =86399）

输出格式：

H:M:S格式的时间

样例输入：

        61

样例输出：

        0:1:1

来源：https://www.dotcpp.com/oj/problem1991.html
难度：中等*/
package test01;

import java.util.Scanner;

public class test8212 {
    public static class Time{ //需要static设置成静态类，否则main函数里需要声明外部类实例test8212后才能声明Time
        private int h;
        private int m;
        private int s;

        public void Set(int t){
            h = t / 3600;
            m = (t - h * 3600) / 60;
            s = t - h * 3600 - m * 60;
        }

        public void Display(){
            System.out.println(h + ":" + m + ":" + s);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Time time = new Time();
        time.Set(t);
        time.Display();
    }
}
