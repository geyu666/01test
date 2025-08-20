/*两个数组的交集

给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。



示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
解释：[4,9] 也是可通过的


提示：

        1 <= nums1.length, nums2.length <= 1000
        0 <= nums1[i], nums2[i] <= 1000

来源：https://leetcode.cn/problems/intersection-of-two-arrays/description/?envType=problem-list-v2&envId=array
难度：简单*/
package test01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test8203 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        String[] strArray1 = input1.replaceAll("[\\[\\]\"]","").split(",");
        String[] strArray2 = input2.replaceAll("[\\[\\]\"]","").split(",");
        int[] nums1 = new int[strArray1.length];
        int[] nums2 = new int[strArray2.length];
        for (int i = 0; i < strArray1.length; i++) {
            nums1[i] = Integer.parseInt(strArray1[i]);
        }
        for (int i = 0; i < strArray2.length; i++){
            nums2[i] = Integer.parseInt(strArray2[i]);
        }

        // 将nums1中的元素加入set1（自动去重）
        for (int num : nums1) {
            set1.add(num);
        }

        // 遍历nums2，检查是否在set1中
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // 输出
        System.out.println(resultSet);
    }
}

