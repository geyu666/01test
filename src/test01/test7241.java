//二分查找
//        给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
//
//        你必须编写一个具有 O(log n) 时间复杂度的算法。
//
//
//        示例 1:
//
//        输入: nums = [-1,0,3,5,9,12], target = 9
//        输出: 4
//        解释: 9 出现在 nums 中并且下标为 4
//        示例 2:
//
//        输入: nums = [-1,0,3,5,9,12], target = 2
//        输出: -1
//        解释: 2 不存在 nums 中因此返回 -1
//
//
//        提示：
//
//        你可以假设 nums 中的所有元素是不重复的。
//        n 将在 [1, 10000]之间。
//        nums 的每个元素都将在 [-9999, 9999]之间。
//
//        来源：https://leetcode.cn/problems/binary-search/description/
//        难度：简单
//        1.输入nums，target
//        2.二分查找
//        （1）定义left,right,mid
//        （2）if nums[mid] > target:
//        right = mid - 1
//        else
//        left = mid + 1
//        （3）输出下标
//
package test01;
import java.util.*;

public class test7241 {
    public static void main(String[] args) {
        //输入一个数组和整数
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] nums = input.replaceAll("[\\[\\] ]", "").split(",");
        int target = sc.nextInt();
        int tIndex = 0;

        //定义left,right,mid
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(Integer.parseInt(nums[mid]) < target) {
                left = mid + 1;
            }
            else if(Integer.parseInt(nums[mid]) > target) {
                right = mid - 1;
            }
            else if(Integer.parseInt(nums[mid]) == target) {
                tIndex = mid;
                break;
            }
        }
        if(left > right){
            tIndex = -1;
        }

        //输出下标
        System.out.println(tIndex);
    }
}
