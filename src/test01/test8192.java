/*汇总区间
给定一个  无重复元素 的 有序 整数数组 nums 。

区间 [a,b] 是从 a 到 b（包含）的所有整数的集合。

返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个区间但不属于 nums 的数字 x 。

列表中的每个区间范围 [a,b] 应该按如下格式输出：

        "a->b" ，如果 a != b
"a" ，如果 a == b


示例 1：

输入：nums = [0,1,2,4,5,7]
输出：["0->2","4->5","7"]
解释：区间范围是：
        [0,2] --> "0->2"
        [4,5] --> "4->5"
        [7,7] --> "7"
示例 2：

输入：nums = [0,2,3,4,6,8,9]
输出：["0","2->4","6","8->9"]
解释：区间范围是：
        [0,0] --> "0"
        [2,4] --> "2->4"
        [6,6] --> "6"
        [8,9] --> "8->9"


提示：

        0 <= nums.length <= 20
        -231 <= nums[i] <= 231 - 1
nums 中的所有值都 互不相同
nums 按升序排列
1.输入转换
2.划分区间
3.转换成字符串
4.输出
来源：https://leetcode.cn/problems/summary-ranges/description/?envType=problem-list-v2&envId=array
难度：简单*/
package test01;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class test8192 {
    public static void main(String[] args) {
        //1.输入转换
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strArray = input.replaceAll("[\\[\\]\"]","").split(",");
        int[] nums = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            nums[i] = Integer.parseInt(strArray[i]);
        }

        //2.划分区间
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<String> arrAll = new ArrayList<>();
        for(int i = 1; i < nums.length; i++){
            boolean flag = false;
            arr.add(nums[i-1]);
            if(nums[i-1]+1 == nums[i]){
                flag = true;
                if(i == nums.length-1 && nums[i] == nums[i-1]+1){
                    arr.add(nums[i]);
                }
            }
            if(!flag){
                arrAll.add(arr.toString());
                arr.clear();
                if(i == nums.length-1 && nums[i] != nums[i-1]+1){
                    arr.add(nums[i]);
                    arrAll.add(arr.toString());
                }
            }
        }

        //3.转换字符串
        ArrayList<String> arrStr = new ArrayList<>();
        for (String str : arrAll) {
            String[] numbers = str.substring(1, str.length() - 1).split(", ");
            arrStr.add(numbers.length == 1 ? numbers[0] : numbers[0] + "->" + numbers[numbers.length - 1]);
        }
        System.out.println(arrStr);
    }
}
