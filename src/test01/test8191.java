/*多数元素
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。



示例 1：

输入：nums = [3,2,3]
输出：3
示例 2：

输入：nums = [2,2,1,1,1,2,2]
输出：2


提示：
n == nums.length
1 <= n <= 5 * 104
        -109 <= nums[i] <= 109

1.转换输入
2.统计元素
（1）根据nums长度，得出总次数m
（2）设立k=1，遍历数组，统计元素出现的次数
（3）对比m与k，返回多数元素
3.输出元素
进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

来源：https://leetcode.cn/problems/majority-element/description/?envType=problem-list-v2&envId=array
难度：简单*/
package test01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class test8191 {
    public static void main(String[] args) {
        //1.输入转换
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strArray = input.replaceAll("[\\[\\]\"]","").split(",");
        int[] nums = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            nums[i] = Integer.parseInt(strArray[i]);
        }
        //2.统计元素
        int m = nums.length / 2 + 1;
        //todo 用HashSet存储元素,可以去重
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            int k = 0;
            for(int j : nums){
                if(i == j){
                    k++;
                }
            }
            if(k >= m){
                set.add(i);
            }
        }
        for(int i : set){
             System.out.print(i + " ");
        }
    }
}
