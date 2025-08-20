/*买卖股票的最佳时机
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。



示例 1：

输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2：

输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。


提示：

        1 <= prices.length <= 105
        0 <= prices[i] <= 104
1.解析输入
2.计算利润
（1）定义min 变量，记录最小值
（2）如果有值小于min，则更新min为当前值
（3）如果有值大于min，则计算并比较利润值，如果利润值>前一天利润值则更新利润值

来源：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=problem-list-v2&envId=array
难度：简单*/
package test01;

import java.util.Scanner;

public class test8182 {
    public static void main(String[] args)
    {
        //todo 解析输入
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] array = str.replaceAll("[\\[\\]\"]", "").split(",");
        int[] prices = new int[array.length];
        for(int i = 0;i < array.length;i++){
            prices[i] = Integer.parseInt(array[i]);
        }

        //todo 获取利润
        int min = prices[0];
        int profit = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] < min){
                min = prices[i];
            }
            else{
                profit = Math.max(profit, prices[i] - min);
            }
        }
        System.out.println(profit);
    }
}
