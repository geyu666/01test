/*给定一个表示 大整数 的整数数组 digits，其中 digits[i] 是整数的第 i 位数字。这些数字按从左到右，从最高位到最低位排列。这个大整数不包含任何前导 0。

        将大整数加 1，并返回结果的数字数组。



        示例 1：

        输入：digits = [1,2,3]
        输出：[1,2,4]
        解释：输入数组表示数字 123。
        加 1 后得到 123 + 1 = 124。
        因此，结果应该是 [1,2,4]。
        示例 2：

        输入：digits = [4,3,2,1]
        输出：[4,3,2,2]
        解释：输入数组表示数字 4321。
        加 1 后得到 4321 + 1 = 4322。
        因此，结果应该是 [4,3,2,2]。
        示例 3：

        输入：digits = [9]
        输出：[1,0]
        解释：输入数组表示数字 9。
        加 1 得到了 9 + 1 = 10。
        因此，结果应该是 [1,0]。


        提示：

        1 <= digits.length <= 100
        0 <= digits[i] <= 9
        digits 不包含任何前导 0。

        来源：https://leetcode.cn/problems/plus-one/description/
        难度：简单*/
package test01;
import java.util.*;

public class test7273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayList<Integer> NewArray = new ArrayList<>();

        // 1. 去除方括号
        String numStr = input.substring(1, input.length() - 1);

        // 2. 按逗号分割成字符串数组
        String[] strArray = numStr.split(",");

        // 3. 转换为int数组
        int[] digits = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            digits[i] = Integer.parseInt(strArray[i]);
        }

        //变成整数
        int num = 0;
        for(int i = digits.length-1; i >= 0; i--){
            num += (int) (digits[i]*Math.pow(10, digits.length-1-i));
        }
        //+1
        num += 1;

        while(num / 10 != 0 || num % 10 != 0){
            NewArray.add(0,num % 10);
            num /= 10;
        }
        System.out.println(NewArray);
    }
}
