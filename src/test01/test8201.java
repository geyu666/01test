/*移动零

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。



示例 1:

输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
示例 2:

输入: nums = [0]
输出: [0]


提示:

        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1
1.输入转换
2.移动零
（1）遍历数组，找到零（2）num = 0，并逐一转换位置，最后一位附上0
3.输出数组

进阶：你能尽量减少完成的操作次数吗？

来源：https://leetcode.cn/problems/move-zeroes/description/?envType=problem-list-v2&envId=array
难度：简单*/
package test01;

import java.util.Scanner;

public class test8201 {
    public static void main(String[] args) {
        //1.输入转换
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strArray = input.replaceAll("[\\[\\]\"]","").split(",");
        int[] nums = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            nums[i] = Integer.parseInt(strArray[i]);
        }

        //2.移动零
        int length = nums.length;
        int n = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                n++;
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                int num = nums[i];
                for(int j = i; j < length - 1; j++){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                nums[length - 1] = num;
                length--;
            }
        }

        //3.输出数组
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
