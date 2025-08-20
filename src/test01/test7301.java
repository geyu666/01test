/*第三大的数
        给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。

        示例 1：

        输入：[3, 2, 1]
        输出：1
        解释：第三大的数是 1 。
        示例 2：

        输入：[1, 2]
        输出：2
        解释：第三大的数不存在, 所以返回最大的数 2 。
        示例 3：

        输入：[2, 2, 3, 1]
        输出：1
        解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
        此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。


        提示：

        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1

        来源：https://leetcode.cn/problems/third-maximum-number/?envType=problem-list-v2&envId=array
        难度：简单*/
package test01;
import java.util.*;
public class test7301 {
    public static void main(String[] args) {
        //1.输入转换
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().replaceAll("[\\[\\]\"]", "");
        String[] strArray = str.split(",");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i].trim());
        }

        //2.遍历，找出first,second,third
        int first = intArray[0];
        int second = -233;
        int third = -233;
        for (int i = 0; i < intArray.length; i++) {
            if(first < intArray[i]){
                first = intArray[i];
            }
        }
        for (int i = 0; i < intArray.length; i++) {
            if(intArray[i] == first){
                continue;
            }
            if(second < intArray[i]){
                second = intArray[i];
            }
        }
        for (int i = 0; i < intArray.length; i++) {
            if(intArray[i] == first || intArray[i] == second){
                continue;
            }
            if(third < intArray[i]){
                third = intArray[i];
            }
        }

        if(third == -233){
            System.out.println(first);
        }
        else{
            System.out.println(third);
        }
    }
}
