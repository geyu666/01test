/*购买两块巧克力

给你一个整数数组 prices ，它表示一个商店里若干巧克力的价格。同时给你一个整数 money ，表示你一开始拥有的钱数。

你必须购买 恰好 两块巧克力，而且剩余的钱数必须是 非负数 。同时你想最小化购买两块巧克力的总花费。

请你返回在购买两块巧克力后，最多能剩下多少钱。如果购买任意两块巧克力都超过了你拥有的钱，请你返回 money 。注意剩余钱数必须是非负数。



示例 1：

输入：prices = [1,2,2], money = 3
输出：0
解释：分别购买价格为 1 和 2 的巧克力。你剩下 3 - 3 = 0 块钱。所以我们返回 0 。
示例 2：

输入：prices = [3,2,3], money = 3
输出：3
解释：购买任意 2 块巧克力都会超过你拥有的钱数，所以我们返回 3 。


提示：

        2 <= prices.length <= 50
        1 <= prices[i] <= 100
        1 <= money <= 100

来源：https://leetcode.cn/problems/buy-two-chocolates/
难度：简单*/
package test01;

import java.util.Scanner;

public class test8243 {
    public static void main(String[] args) {
        //输入转换
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int money = sc.nextInt();
        String[] arr = s.replaceAll("[\\[\\]\"]", "").split(",");
        int[] prices = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            prices[i] = Integer.parseInt(arr[i]);
        }

        //找到最小和第二小数
        int min = 100;
        int secondMin = 100;
        for(int price : prices){
            if(price < min){
                secondMin = min;
                min = price;
            }
            else if(price < secondMin){
                secondMin = price;
            }
        }

        //判断
        int sum = min + secondMin;
        if(sum > money){
            System.out.println(money);
        }
        else{
            System.out.println(money - sum);
        }
    }
}
