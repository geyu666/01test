//颈椎病治疗
//        最近云海学长一直对着电脑改bug, 颈椎不舒服, 希望各位小伙伴帮云海学长治治
//        提供一张图片, 将图片旋转后再发给云海学长, 这样学长看图的时候就需要歪着脖子, 时间久了, 颈椎病就治
//        好了
//        输入一个数字构成的矩形, 将矩形的值进行90度旋转后打印
//        输入:
//        第一行 正整数n(1<n<10), 表示矩阵的边长
//        随后输入一个矩阵
//        输出:
//        90度旋转后的矩阵
//        样例输入:
//        3
//        1 2 3
//        4 5 6
//        7 8 9
//        样例输出:
//        7 4 1
//        8 5 2
//        9 6 3
//
//        来源：日常练习题-多维数组-第2题
//        难度：简单
package test01;

import java.util.Scanner;

public class test7252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0;i < n;i++)
        {
            sc.nextLine();
            for(int j = 0;j < n;j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = n-1;i >= 0;i--)
        {
            for(int j = n-1;j >= 0;j--)
            {
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
    }
}
