/*只出现一次的数字

给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。

示例 1 ：

输入：nums = [2,2,1]

输出：1

示例 2 ：

输入：nums = [4,1,2,1,2]

输出：4

示例 3 ：

输入：nums = [1]

输出：1

提示：

        1 <= nums.length <= 3 * 104
        -3 * 104 <= nums[i] <= 3 * 104
除了某个元素只出现一次以外，其余每个元素均出现两次。

1.转换输入为数组
2.对数组元素进行异或运算
3.返回结果
来源：https://leetcode.cn/problems/single-number/description/?envType=problem-list-v2&envId=array
难度：简单*/
package test01;

import java.util.Scanner;

public class test8183 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] array = str.replaceAll("[\\[\\]\"]","").split(",");
        int[] nums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            nums[i] = Integer.parseInt(array[i]);
        }
        int num = 0;
        for (int i = 0; i < nums.length;i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length;j++) {
                if(i == j){
                    continue;
                }
                if (nums[j] == nums[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                num = nums[i];
                break;
            }
        }
        System.out.println(num);
    }
}
