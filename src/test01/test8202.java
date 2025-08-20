/*区域和检索 - 数组不可变

给定一个整数数组  nums，处理以下类型的多个查询:

计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
实现 NumArray 类：

NumArray(int[] nums) 使用数组 nums 初始化对象
int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )


示例 1：

输入：
        ["NumArray", "sumRange", "sumRange", "sumRange"]
        [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
输出：
        [null, 1, -1, -3]

解释：
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
        numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))


提示：

        1 <= nums.length <= 104
        -105 <= nums[i] <= 105
        0 <= i <= j < nums.length
最多调用 104 次 sumRange 方法

来源：https://leetcode.cn/problems/range-sum-query-immutable/description/?envType=problem-list-v2&envId=array
难度：简单*/
package test01;

import java.util.ArrayList;

public class test8202 {
    public static class NumArray {
        private final int[] sumArrays; //前缀和数组

        public NumArray(int[] nums) {
            sumArrays = new int[nums.length+1];

            for (int i = 0; i < nums.length; i++) {
                sumArrays[i+1] = sumArrays[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sumArrays[j+1] - sumArrays[i];
        }
    }
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        ArrayList<Integer> list = new ArrayList<>();
        list.add(numArray.sumRange(0, 2));
        list.add(numArray.sumRange(2, 5));
        list.add(numArray.sumRange(0, 5));
        System.out.println(list);
    }
}
