//2. 合并有序数组
//        阿伟学长终于写好了游戏背包1和背包2的排序算法, 但他发现将两个背包同时带上时, 还得合并一下排序.
//        阿伟学长懒得再写排序了, 希望小伙伴能帮帮他完成背包的合并.
//        设计一个程序, 输入两个有序数组, 输出一个合并后的有序数组.
//        输入:
//        第一行: 整数n,m 表示数组1和数组2分别有n,m个数字
//        第二行: n个整数Ni, 表示数组1的每个元素
//        第三行: m个整数Mi, 表示数组2的每个元素
//        (n,m<=100. 0<=Ni,Mi<=1000)
//        输出:
//        合并后的新数组
//        样例输入:
//        5 6
//        1 3 5 7 9
//        1 3 5 6 7 8
//        输出:
//        1 1 3 3 5 5 6 7 7 8 9
//
//        来源：每日练习题-一维数组-第2题
//        难度：简单
package test01;
import java.util.*;

public class test7242 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入m,n
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();//换行符
        //输入两个数组
        ArrayList<Integer> listm = new ArrayList<>();
        ArrayList<Integer> listn = new ArrayList<>();
        for (int i = 0; i <= m-1; i++) {
            listm.add(sc.nextInt());
        }
        sc.nextLine();
        for (int i = 0; i <= n-1; i++) {
            listn.add(sc.nextInt());
        }

        listm.addAll(listn);
        Collections.sort(listm);

        System.out.println(listm);
    }
}

